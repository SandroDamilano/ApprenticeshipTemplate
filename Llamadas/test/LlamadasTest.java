import org.junit.Assert;
import org.junit.Test;

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

}
