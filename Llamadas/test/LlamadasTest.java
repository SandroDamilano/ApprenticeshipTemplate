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
    public void unaLlamadaNacionalDe1MinutoCuesta30Centavos() {
        Assert.assertEquals(0.30, new LlamadaNacional(1).costo(), 0.01);
    }

    @Test
    public void unaLlamadaNacionalDe2MinutoCuesta60Centavos() {
        Assert.assertEquals(0.60, new LlamadaNacional(2).costo(), 0.01);
    }

    @Test
    public void unaLlamadaNacionalCuesta30CentavosPorMinuto() {
        Assert.assertEquals(6.00, new LlamadaNacional(20).costo(), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalASudamericaDe1MinutoCuesta50Centavos() {
        Assert.assertEquals(0.50, new LlamadaInternacional(1, "Sudamerica").costo(), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalASudamericaDe2MinutoCuesta1Peso() {
        Assert.assertEquals(1.00, new LlamadaInternacional(2, "Sudamerica").costo(), 0.01);
    }


}
