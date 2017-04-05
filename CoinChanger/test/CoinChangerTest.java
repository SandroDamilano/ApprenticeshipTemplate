import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CoinChangerTest {

    @Test
    public void testElCambioDe1Es1MonedaDe1() {
        List<Integer> denominaciones = Arrays.asList(1, 5, 10, 25, 50, 100);
        CoinChanger coinChanger = new CoinChanger();
        assert(coinChanger.mejorCambioDe(1, denominaciones).esIgualA(new Cambio(Arrays.asList(1))));
    }

    @Test
    public void testElCambioDe2Son2MonedasDe1() {
        List<Integer> denominaciones = Arrays.asList(1, 5, 10, 25, 50, 100);
        CoinChanger coinChanger = new CoinChanger();
        assert(coinChanger.mejorCambioDe(2, denominaciones).esIgualA(new Cambio(Arrays.asList(1, 1))));
    }

    @Test
    public void testElCambioDe6Son1MonedaDe5Y1De1() {
        List<Integer> denominaciones = Arrays.asList(1, 5, 10, 25, 50, 100);
        CoinChanger coinChanger = new CoinChanger();
        assert(coinChanger.mejorCambioDe(6, denominaciones).esIgualA(new Cambio(Arrays.asList(5, 1))));
    }

    @Test
    public void testElCambioDe21Son2MonedasDe10Y1De1() {
        List<Integer> denominaciones = Arrays.asList(1, 5, 10, 25, 50, 100);
        CoinChanger coinChanger = new CoinChanger();
        assert(coinChanger.mejorCambioDe(21, denominaciones).esIgualA(new Cambio(Arrays.asList(10, 10, 1))));
    }

    @Test
    public void testElCambioDe14ConDenominacionesDe1De7YDe10Son2MonedasDe7() {
        List<Integer> denominaciones = Arrays.asList(1, 7, 10);
        CoinChanger coinChanger = new CoinChanger();
        assert(coinChanger.mejorCambioDe(14, denominaciones).esIgualA(new Cambio(Arrays.asList(7, 7))));
    }
}
