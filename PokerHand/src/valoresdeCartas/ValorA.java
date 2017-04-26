package valoresdeCartas;

/**
 * Created by sandro on 10/04/17.
 */
public class ValorA implements ValorNoNumericoDeCarta {

    @Override
    public boolean canHandle(String unValor) {
        return unValor == "A";
    }

    @Override
    public boolean esMayorQue(ValorDeCarta otroValor) {
        return otroValor.esMenorQueA();
    }

    @Override
    public boolean esMenorQueA() {
        return false;
    }

    @Override
    public boolean esMenorQueK() {
        return false;
    }

    @Override
    public boolean esMenorQueQ() {
        return false;
    }

    @Override
    public boolean esMenorQueJ() {
        return false;
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