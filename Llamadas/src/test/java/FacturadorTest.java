import org.joda.time.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sandro on 02/05/17.
 */
public class FacturadorTest {

    @Test
    public void cuandoNoSeRealizaronLlamadasEnElMesElPagoEsDe10Pesos() {
        Double montoEsperado = 10.0;
        LineaTelefonica lineaTelefonica = new LineaTelefonica();
        Assert.assertEquals(montoEsperado, new FacturaTelefonica(new YearMonth(2017, 4), lineaTelefonica).monto());
    }

    @Test
    public void cuandoSoloSeRealizoUnaLlamadaNacionalEnElMesElMontoDeLaFacturaEsDe10PesosMasElCostoDeLaLlamada(){
        LlamadaNacional llamada = new LlamadaNacional(new Interval(new DateTime(2017, 5, 2, 13, 30), Duration.standardMinutes(20)));
        LineaTelefonica lineaTelefonica = new LineaTelefonica();
        FacturaTelefonica factura = new FacturaTelefonica(new YearMonth(2017, 5), lineaTelefonica);
        lineaTelefonica.agregarLlamada(llamada);
        Assert.assertEquals(10.0 + llamada.costo(), factura.monto(), 0.001);
    }

    @Test
    public void cuandoSoloSeRealizaronLlamadasNacionalesEnElMesElMontoDeLaFacturaEsDe10PesosMasElCostoDeLaSumaDeLasLlamadas(){
        LlamadaNacional llamada1 = new LlamadaNacional(new Interval(new DateTime(2017, 5, 2, 13, 30), Duration.standardMinutes(20)));
        LlamadaNacional llamada2 = new LlamadaNacional(new Interval(new DateTime(2017, 5, 3, 13, 30), Duration.standardMinutes(10)));
        LineaTelefonica lineaTelefonica = new LineaTelefonica();
        FacturaTelefonica factura = new FacturaTelefonica(new YearMonth(2017, 5), lineaTelefonica);
        lineaTelefonica.agregarLlamada(llamada1);
        lineaTelefonica.agregarLlamada(llamada2);
        Assert.assertEquals(10 + llamada1.costo() + llamada2.costo(), factura.monto(), 0.001);
    }

    @Test
    public void cuandoSeRealizaronLlamadasNacionalesEnDistintosMesesElMontoDeLaFacturaDeUnMesCorrespondeSoloALasLlamadasDeEseMes(){
        LlamadaNacional llamada1 = new LlamadaNacional(new Interval(new DateTime(2017, 5, 2, 13, 30), Duration.standardMinutes(20)));
        LlamadaNacional llamada2 = new LlamadaNacional(new Interval(new DateTime(2017, 6, 3, 13, 30), Duration.standardMinutes(10)));
        LineaTelefonica lineaTelefonica = new LineaTelefonica();
        FacturaTelefonica factura = new FacturaTelefonica(new YearMonth(2017, 6), lineaTelefonica);
        lineaTelefonica.agregarLlamada(llamada1);
        lineaTelefonica.agregarLlamada(llamada2);
        Assert.assertEquals(10 + llamada2.costo(), factura.monto(), 0.001);
    }



}
