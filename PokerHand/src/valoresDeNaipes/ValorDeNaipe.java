package valoresDeNaipes;

/**
 * Created by sandro on 10/04/17.
 */
public interface ValorDeNaipe {

    boolean esMayorQue(ValorDeNaipe otroValor);
    boolean esMenorQueA();
    boolean esMenorQueK();
    boolean esMenorQueQ();
    boolean esMenorQueJ();
    boolean esMenorQueT();
    boolean esMenorQue(Integer valor);
}
