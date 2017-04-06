import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CoinChangerTest {

    @Test
    public void testUnCambioEsIgualAOtroSiTieneMonedasDeLaMismaDenominacion(){
        assert(new Cambio(Arrays.asList(1,2,5,10)).esIgualA(new Cambio(Arrays.asList(10,2,5,1))));
    }

    @Test
    public void testUnCambioEsDistintoAOtroSiTieneMasCantidadDeMonedas(){
        assert(!new Cambio(Arrays.asList(1,2,5,10,10,10)).esIgualA(new Cambio(Arrays.asList(1,2,5,10,10))));
    }

    @Test
    public void testUnCambioEsDistintoAOtroSiTieneMenosCantidadDeMonedas(){
        assert(!new Cambio(Arrays.asList(1,2,5,10)).esIgualA(new Cambio(Arrays.asList(1,2,5,10,10))));
    }

    @Test
    public void testUnCambioEsDistintoAOtroSiTieneDistintasMonedas(){
        assert(!new Cambio(Arrays.asList(1,2,5,10)).esIgualA(new Cambio(Arrays.asList(1,2,50,10))));
    }

    @Test
    public void testElMejorCambioDeUnValorConDenominacionExistenteEsLaMonedaDeEseValor() {
        List<Integer> denominaciones = Arrays.asList(1, 5, 10, 25, 50, 100);
        CoinChanger coinChanger = new CoinChanger();
        assert(coinChanger.mejorCambioDe(1, denominaciones).esIgualA(new Cambio(Arrays.asList(1))));
    }

    @Test
    public void testElMejorCambioPuedeContenerMasDeUnaMonedaConLaMismaDenominacion() {
        List<Integer> denominaciones = Arrays.asList(1, 5, 10, 25, 50, 100);
        CoinChanger coinChanger = new CoinChanger();
        assert(coinChanger.mejorCambioDe(2, denominaciones).esIgualA(new Cambio(Arrays.asList(1, 1))));
    }

    @Test
    public void testElMejorCambioDeUnValorSinDenominacionExistenteSonMasDeUnaMoneda() {
        List<Integer> denominaciones = Arrays.asList(1, 5, 10, 25, 50, 100);
        CoinChanger coinChanger = new CoinChanger();
        assert(coinChanger.mejorCambioDe(6, denominaciones).esIgualA(new Cambio(Arrays.asList(5, 1))));
    }

    @Test
    public void testElMejorCambioNoNecesariamenteIncluyeALaMonedaDeDenominacionInmediatamenteAnteriorAlMonto() {
        List<Integer> denominaciones = Arrays.asList(1, 7, 10);
        CoinChanger coinChanger = new CoinChanger();
        Cambio mejorCambio = coinChanger.mejorCambioDe(14, denominaciones);
        assert(mejorCambio.esIgualA(new Cambio(Arrays.asList(7, 7))));
    }

    @Test
    public void testElMejorCambioEsElMismoAPesarDelOrdenEnElQueAparezcanLasDenominaciones() {
        List<Integer> unasDenominaciones = Arrays.asList(1, 5, 7, 10);
        List<Integer> otrasDenominaciones = Arrays.asList(5, 1, 10, 7);
        CoinChanger coinChanger = new CoinChanger();
        Cambio unMejorCambio = coinChanger.mejorCambioDe(12, unasDenominaciones);
        Cambio otroMejorCambio = coinChanger.mejorCambioDe(12, otrasDenominaciones);
        assert(unMejorCambio.esIgualA(otroMejorCambio));
    }
}
