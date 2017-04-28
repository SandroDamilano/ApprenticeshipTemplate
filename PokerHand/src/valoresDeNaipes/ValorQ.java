package valoresDeNaipes;

/**
 * Created by sandro on 10/04/17.
 */
public class ValorQ implements ValorNoNumericoDeNaipe {

    @Override
    public boolean canHandle(String unValor) {
        return unValor == "Q";
    }

    @Override
    public boolean esMayorQue(ValorDeNaipe otroValor) {
        return otroValor.esMenorQueQ();
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
