import main.*;
import org.joda.time.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sandro on 02/05/17.
 */
public class FacturadorTest {

    private LlamadasTestFactory factory;

    @Before
    public void setUp(){
        factory = new LlamadasTestFactory();
    }

    @Test
    public void cuandoNoSeRealizaronLlamadasEnElMesElPagoEsDe10Pesos() {
        Assert.assertEquals((Double) 10.0, new FacturaTelefonica(new YearMonth(2017, 4), factory.lineaTelefonica()).montoCon(factory.nuevoFacturador()));
    }

    @Test
    public void cuandoSoloSeRealizoUnaLlamadaEnElMesElMontoDeLaFacturaEsDe10PesosMasElCostoDeLaLlamada(){
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 5, 2, 13, 30), Duration.standardMinutes(20));
        Llamada llamada = new Llamada(factory.telefonoBsAs(), factory.telefonoCordoba(), intervaloDeLlamada);
        FacturaTelefonica factura = new FacturaTelefonica(new YearMonth(2017, 5), factory.lineaTelefonica());
        factory.lineaTelefonica().agregarLlamada(llamada);
        Assert.assertEquals(10.0 + factory.nuevoFacturador().montoDe(llamada), factura.montoCon(factory.nuevoFacturador()), 0.001);
    }

    @Test
    public void cuandoSoloSeRealizaronLlamadasNacionalesEnElMesElMontoDeLaFacturaEsDe10PesosMasElCostoDeLaSumaDeLasLlamadas(){
        Interval intervaloDeLlamada1 = new Interval(new DateTime(2017, 5, 2, 13, 30), Duration.standardMinutes(20));
        Llamada llamada1 = new Llamada(factory.telefonoBsAs(), factory.telefonoCordoba(), intervaloDeLlamada1);
        Interval intervaloDeLlamada2 = new Interval(new DateTime(2017, 5, 3, 13, 30), Duration.standardMinutes(10));
        Llamada llamada2 = new Llamada(factory.telefonoBsAs(), factory.telefonoCordoba(), intervaloDeLlamada2);
        FacturaTelefonica factura = new FacturaTelefonica(new YearMonth(2017, 5), factory.lineaTelefonica());
        factory.lineaTelefonica().agregarLlamada(llamada1);
        factory.lineaTelefonica().agregarLlamada(llamada2);
        Assert.assertEquals(10 + factory.nuevoFacturador().montoDe(llamada1) + factory.nuevoFacturador().montoDe(llamada2), factura.montoCon(factory.nuevoFacturador()), 0.001);
    }

    @Test
    public void cuandoSeRealizaronLlamadasNacionalesEnDistintosMesesElMontoDeLaFacturaDeUnMesCorrespondeSoloALasLlamadasDeEseMes(){
        Interval intervaloDeLlamada1 = new Interval(new DateTime(2017, 5, 2, 13, 30), Duration.standardMinutes(20));
        Llamada llamada1 = new Llamada(factory.telefonoBsAs(), factory.telefonoCordoba(), intervaloDeLlamada1);
        Interval intervaloDeLlamada2 = new Interval(new DateTime(2017, 6, 3, 13, 30), Duration.standardMinutes(10));
        Llamada llamada2 = new Llamada(factory.telefonoBsAs(), factory.telefonoCordoba(), intervaloDeLlamada2);
        FacturaTelefonica factura = new FacturaTelefonica(new YearMonth(2017, 6), factory.lineaTelefonica());
        factory.lineaTelefonica().agregarLlamada(llamada1);
        factory.lineaTelefonica().agregarLlamada(llamada2);
        Assert.assertEquals(10 + factory.nuevoFacturador().montoDe(llamada2), factura.montoCon(factory.nuevoFacturador()), 0.001);
    }



}
