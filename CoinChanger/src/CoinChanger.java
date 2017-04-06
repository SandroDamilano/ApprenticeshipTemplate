import java.util.*;
import java.util.stream.Stream;

public class CoinChanger {

    public Cambio mejorCambioDe(int monto, List<Integer> denominaciones){
        List<Cambio> cambiosPosibles = todosLosCambiosPosiblesPara(monto, new LinkedList<>(denominaciones), new ArrayList<>());
        return cambiosPosibles.stream().reduce((unCambio, otroCambio) -> unCambio.tieneMenosMonedasQue(otroCambio) ? unCambio : otroCambio).get();
    }

    protected List<Cambio> todosLosCambiosPosiblesPara(int monto, List<Integer> denominaciones, List<Cambio> cambios){
        cambios.add(cambioDe(monto, monto, denominaciones, new Cambio(Arrays.asList())));
        denominaciones.remove(denominaciones.stream().max(Comparator.naturalOrder()).get());

        if(denominaciones.isEmpty()){
            return cambios;
        }else{
            return todosLosCambiosPosiblesPara(monto, denominaciones, cambios);
        }
    }

    protected Cambio cambioDe(int montoTotal, int montoRestante, List<Integer> denominaciones, Cambio unCambio){
        Stream<Integer> denominacionesValidas = denominaciones.stream().filter(denominacion -> denominacion <= montoRestante);

        unCambio.agregarMoneda(denominacionesValidas.max(Comparator.naturalOrder()).get());

        if(unCambio.monto() < montoTotal){
            return this.cambioDe(montoTotal, montoTotal - unCambio.monto(), denominaciones, unCambio);
        }

        return unCambio;
    }
}
