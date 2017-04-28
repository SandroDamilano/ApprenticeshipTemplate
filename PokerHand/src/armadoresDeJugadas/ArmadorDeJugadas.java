package armadoresDeJugadas;

import jugadas.TipoDeJugada;
import main.ConjuntoDeNaipes;
import main.PokerHand;

/**
 * Created by sandro on 21/04/17.
 */
public interface ArmadorDeJugadas {

    boolean canHandle(PokerHand unaMano);
    TipoDeJugada armarJugada(ConjuntoDeNaipes unosNaipes);

}
