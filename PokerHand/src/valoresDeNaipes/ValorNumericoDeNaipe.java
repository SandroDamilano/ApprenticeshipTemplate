package valoresDeNaipes;


/**
 * Created by sandro on 10/04/17.
 */
public class ValorNumericoDeNaipe implements ValorDeNaipe {
    protected int numero;

    public ValorNumericoDeNaipe(Integer unValor){
//        if(unValor < 2 || unValor > 9)
//            throw new CartaInvalidaException();
        numero = unValor;
    }

    @Override
    public boolean esMayorQue(ValorDeNaipe otroValor) {
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
