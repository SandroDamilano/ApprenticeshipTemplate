import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CoinChanger {

    protected Cambio cambio = new Cambio(Arrays.asList());

    public Cambio cambioDe(int monto, List<Integer> denominaciones){
        Stream<Integer> denominacionesValidas = denominaciones.stream().filter(denominacion -> denominacion <= monto);

        cambio.agregarMoneda(denominacionesValidas.max(Comparator.naturalOrder()).get());

        if(cambio.monto() < monto){
             return this.cambioDe(monto - cambio.monto(), denominaciones);
        }

        return cambio;
    }
}
