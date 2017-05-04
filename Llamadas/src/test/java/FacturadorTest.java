import main.*;
import org.joda.time.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sandro on 02/05/17.
 */
public class FacturadorTest {

    private LineaTelefonica lineaTelefonica;
    private Facturador facturador;

    @Before
    public void setUp(){
        lineaTelefonica = new LineaTelefonica();

        List<String> codigosDeSudamerica = Arrays.asList("54", "22");
        List<String> codigosDeNorteamerica = Arrays.asList("1");
        List<String> codigosDeEuropa = Arrays.asList("12");
        List<String> codigosDelRestoDelMundo = Arrays.asList("80");
        Map<String, List<String>> listadoDeCodigosDePaisesPorRegion = new HashMap<>();
        listadoDeCodigosDePaisesPorRegion.put("Sudamerica", codigosDeSudamerica);
        listadoDeCodigosDePaisesPorRegion.put("Norteamerica", codigosDeNorteamerica);
        listadoDeCodigosDePaisesPorRegion.put("Europa", codigosDeEuropa);
        listadoDeCodigosDePaisesPorRegion.put("RestoDelMundo", codigosDelRestoDelMundo);

        facturador = new Facturador(listadoDeCodigosDePaisesPorRegion);
    }

    @Test
    public void cuandoNoSeRealizaronLlamadasEnElMesElPagoEsDe10Pesos() {
        Assert.assertEquals((Double) 10.0, new FacturaTelefonica(new YearMonth(2017, 4), lineaTelefonica).montoCon(facturador));
    }

    @Test
    public void cuandoSoloSeRealizoUnaLlamadaEnElMesElMontoDeLaFacturaEsDe10PesosMasElCostoDeLaLlamada(){
        Telefono telefonoBsAs = new Telefono("+54", 011, 45671234);
        Telefono telefonoCordoba = new Telefono("+54", 015, 3245673);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 5, 2, 13, 30), Duration.standardMinutes(20));
        Llamada llamada = new Llamada(telefonoBsAs, telefonoCordoba, intervaloDeLlamada);
        FacturaTelefonica factura = new FacturaTelefonica(new YearMonth(2017, 5), lineaTelefonica);
        lineaTelefonica.agregarLlamada(llamada);
        Assert.assertEquals(10.0 + facturador.montoDe(llamada), factura.montoCon(facturador), 0.001);
    }

    @Test
    public void cuandoSoloSeRealizaronLlamadasNacionalesEnElMesElMontoDeLaFacturaEsDe10PesosMasElCostoDeLaSumaDeLasLlamadas(){
        Telefono telefonoBsAs = new Telefono("+54", 011, 45671234);
        Telefono telefonoCordoba = new Telefono("+54", 015, 3245673);
        Interval intervaloDeLlamada1 = new Interval(new DateTime(2017, 5, 2, 13, 30), Duration.standardMinutes(20));
        Llamada llamada1 = new Llamada(telefonoBsAs, telefonoCordoba, intervaloDeLlamada1);
        Interval intervaloDeLlamada2 = new Interval(new DateTime(2017, 5, 3, 13, 30), Duration.standardMinutes(10));
        Llamada llamada2 = new Llamada(telefonoBsAs, telefonoCordoba, intervaloDeLlamada2);
        FacturaTelefonica factura = new FacturaTelefonica(new YearMonth(2017, 5), lineaTelefonica);
        lineaTelefonica.agregarLlamada(llamada1);
        lineaTelefonica.agregarLlamada(llamada2);
        Assert.assertEquals(10 + facturador.montoDe(llamada1) + facturador.montoDe(llamada2), factura.montoCon(facturador), 0.001);
    }

    @Test
    public void cuandoSeRealizaronLlamadasNacionalesEnDistintosMesesElMontoDeLaFacturaDeUnMesCorrespondeSoloALasLlamadasDeEseMes(){
        Telefono telefonoBsAs = new Telefono("+54", 011, 45671234);
        Telefono telefonoCordoba = new Telefono("+54", 015, 3245673);
        Interval intervaloDeLlamada1 = new Interval(new DateTime(2017, 5, 2, 13, 30), Duration.standardMinutes(20));
        Llamada llamada1 = new Llamada(telefonoBsAs, telefonoCordoba, intervaloDeLlamada1);
        Interval intervaloDeLlamada2 = new Interval(new DateTime(2017, 6, 3, 13, 30), Duration.standardMinutes(10));
        Llamada llamada2 = new Llamada(telefonoBsAs, telefonoCordoba, intervaloDeLlamada2);
        FacturaTelefonica factura = new FacturaTelefonica(new YearMonth(2017, 6), lineaTelefonica);
        lineaTelefonica.agregarLlamada(llamada1);
        lineaTelefonica.agregarLlamada(llamada2);
        Assert.assertEquals(10 + facturador.montoDe(llamada2), factura.montoCon(facturador), 0.001);
    }



}
