package valoresdeCartas;
import exceptions.CartaInvalidaException;


/**
 * Created by sandro on 10/04/17.
 */
public class ValorNumerico implements ValorDeCarta {
    protected int numero;

    public ValorNumerico(Integer unValor){
//        if(unValor < 2 || unValor > 9)
//            throw new CartaInvalidaException();
        numero = unValor;
    }

    @Override
    public boolean esMayorQue(ValorDeCarta otroValor) {
        return otroValor.esMenorQue(numero);
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
        return true;
    }

    @Override
    public boolean esMenorQue(Integer valor) {
        return numero < valor;
    }
}
