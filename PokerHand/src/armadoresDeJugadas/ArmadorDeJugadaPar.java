package armadoresDeJugadas;

import jugadas.JugadaPar;
import jugadas.TipoDeJugada;
import main.ConjuntoDeNaipes;
import main.PokerHand;

/**
 * Created by sandro on 21/04/17.
 */
public class ArmadorDeJugadaPar implements ArmadorDeJugadas {
    @Override
    public boolean canHandle(PokerHand unaMano) {
        return unaMano.naipesRepetidos().cantidad() == 2;
    }

    @Override
    public TipoDeJugada armarJugada(ConjuntoDeNaipes unosNaipes) {
        return new JugadaPar(unosNaipes);
    }
}
