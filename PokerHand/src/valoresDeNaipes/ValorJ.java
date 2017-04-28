package valoresDeNaipes;

/**
 * Created by sandro on 10/04/17.
 */
public class ValorJ implements ValorNoNumericoDeNaipe {

    @Override
    public boolean canHandle(String unValor) {
        return unValor == "J";
    }

    @Override
    public boolean esMayorQue(ValorDeNaipe otroValor) {
        return otroValor.esMenorQueJ();
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
