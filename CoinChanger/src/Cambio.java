import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cambio {

    protected List<Moneda> monedas = new ArrayList<>();

    public Cambio(List<Integer> denominaciones){
        monedas = denominaciones.stream().map(denominacion -> new Moneda(denominacion)).collect(Collectors.toList());
    }

    public void agregarMoneda(int unaDenominacion){
        Moneda moneda = new Moneda(unaDenominacion);
        monedas.add(moneda);
    }

    public int monto(){
        return monedas.stream().reduce(new Moneda(0), (unaMoneda, otraMoneda) -> unaMoneda.sumar(otraMoneda)).denominacion;
    }

    public boolean esIgualA(Cambio otroCambio){
        return tieneLaMismaCantidadDeMonedasQue(otroCambio) && tieneLasMismasMonedasQue(otroCambio);
    }

    protected boolean tieneLaMismaCantidadDeMonedasQue(Cambio otroCambio){
        return this.cantidadDeMonedas() == otroCambio.cantidadDeMonedas();
    }

    protected boolean tieneLasMismasMonedasQue(Cambio otroCambio){
        List<Moneda> misMonedas = monedas.stream().sorted(Comparator.comparingInt(Moneda::denominacion)).collect(Collectors.toList());
        List<Moneda> susMonedas = otroCambio.monedas.stream().sorted(Comparator.comparingInt(Moneda::denominacion)).collect(Collectors.toList());

        return misMonedas.stream().allMatch(unaMoneda ->
                susMonedas.get(misMonedas.indexOf(unaMoneda)).denominacion() == unaMoneda.denominacion()
        );
    }

    public boolean tieneMenosMonedasQue(Cambio otroCambio){
        return cantidadDeMonedas() < otroCambio.cantidadDeMonedas();
    }

    protected int cantidadDeMonedas(){
        return monedas.size();
    }
}
