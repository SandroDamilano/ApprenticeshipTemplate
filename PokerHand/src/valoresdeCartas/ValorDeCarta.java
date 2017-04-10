package valoresdeCartas;

/**
 * Created by sandro on 10/04/17.
 */
public interface ValorDeCarta {

    boolean esMayorQue(ValorDeCarta otroValor);
    boolean esMenorQueA();
    boolean esMenorQueK();
    boolean esMenorQueQ();
    boolean esMenorQueJ();
    boolean esMenorQueT();
    boolean esMenorQue(Integer valor);
}
