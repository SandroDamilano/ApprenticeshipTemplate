import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by sandro on 02/05/17.
 */
public class LlamadasTest {

    @Test
    public void cuandoNoSeRealizaronLlamadasEnElMesElPagoEsDe10Pesos() {
        Integer montoEsperado = 10;
        Assert.assertEquals(montoEsperado, new FacturaTelefonica().monto());
    }

    @Test
    public void unaLlamadaNacionalCuesta30CentavosPorMinuto() {
        Assert.assertEquals(6.00, new LlamadaNacional(20).costo(), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalASudamericaCuesta50CentavosElMinuto() {
        Assert.assertEquals(8.00, new LlamadaInternacional(16, "Sudamerica").costo(), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalANorteAmericaCuesta70CentavosElMinuto() {
        Assert.assertEquals(21.00, new LlamadaInternacional(30, "Norte-America").costo(), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalAEuropaCuesta70CentavosElMinuto() {
        Assert.assertEquals(14.00, new LlamadaInternacional(20, "Europa").costo(), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalAlRestoDelMundoCuesta1Peso50CentavosElMinuto() {
        Assert.assertEquals(22.50, new LlamadaInternacional(15, "Australia").costo(), 0.01);
    }

    @Test
    public void unaLlamadaLocalEnFinDeSemanaCuesta10CentavosElMinuto() {
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 29, 17, 00), Duration.standardMinutes(25));
        Assert.assertEquals(2.50, new LlamadaLocal(intervaloDeLlamada).costo(), 0.01);
    }

    @Test
    public void unaLlamadaLocalEnDiaHabilFueraDeHoraPicoCuesta10CentavosElMinuto() {
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 20, 00), Duration.standardMinutes(20));
        Assert.assertEquals(2.00, new LlamadaLocal(intervaloDeLlamada).costo(), 0.01);
    }

    @Test
    public void unaLlamadaLocalEnDiaHabilYHoraPicoCuesta20CentavosElMinuto() {
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(47));
        Assert.assertEquals(9.40, new LlamadaLocal(intervaloDeLlamada).costo(), 0.01);
    }

}
