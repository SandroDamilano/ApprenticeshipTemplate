import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CoinChanger {

    protected Cambio cambio = new Cambio(Arrays.asList());

    public Cambio mejorCambioDe(int monto, List<Integer> denominaciones){
//        Stream<Integer> denominacionesValidas = denominaciones.stream().filter(denominacion -> denominacion <= monto);
//
//        cambio.agregarMoneda(denominacionesValidas.max(Comparator.naturalOrder()).get());
//
//        if(cambio.monto() < monto){
//             return this.mejorCambioDe(monto - cambio.monto(), denominaciones);
//        }
//
//        return cambio;
        List<Cambio> cambiosPosibles = todosLosCambiosPosiblesPara(monto, denominaciones, new ArrayList<>());
        return cambiosPosibles.stream().min(Comparator.comparing(new Cambio(Arrays.asList())::tieneMenosMonedasQue)).get();
    }

    protected List<Cambio> todosLosCambiosPosiblesPara(int monto, List<Integer> denominaciones, List<Cambio> cambios){
        cambios.add(cambioDe(monto, denominaciones));
        denominaciones.remove(denominaciones.size()-1);

        if(denominaciones.isEmpty()){
            return cambios;
        }else{
            return todosLosCambiosPosiblesPara(monto, denominaciones, cambios);
        }
    }

    protected Cambio cambioDe(int monto, List<Integer> denominaciones){
        Stream<Integer> denominacionesValidas = denominaciones.stream().filter(denominacion -> denominacion <= monto);

        cambio.agregarMoneda(denominacionesValidas.max(Comparator.naturalOrder()).get());

        if(cambio.monto() < monto){
            return this.cambioDe(monto - cambio.monto(), denominaciones);
        }

        return cambio;
    }
}
