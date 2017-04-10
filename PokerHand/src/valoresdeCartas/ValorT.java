package valoresdeCartas;

/**
 * Created by sandro on 10/04/17.
 */
public class ValorT implements ValorNoNumericoDeCarta {

    @Override
    public boolean canHandle(String unValor) {
        return unValor == "T";
    }

    @Override
    public boolean esMayorQue(ValorDeCarta otroValor) {
        return otroValor.esMenorQueT();
    }

    @Override
    public boolean esMenorQueA() {
        return true;
    }

    @Override
    public boolean esMenorQueK() {
        return true;
    }

    @Override
    public boolean esMenorQueQ() {
        return true;
    }

    @Override
    public boolean esMenorQueJ() {
        return true;
    }

    @Override
    public boolean esMenorQueT() {
        return false;
    }

    @Override
    public boolean esMenorQue(Integer valor) {
        return false;
    }
}
