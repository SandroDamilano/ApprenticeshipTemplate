package armadoresDeJugadas;

import jugadas.JugadaPierna;
import jugadas.TipoDeJugada;
import main.ConjuntoDeNaipes;
import main.PokerHand;

/**
 * Created by sandro on 28/04/17.
 */
public class ArmadorDeJugadaPierna implements ArmadorDeJugadas {
    @Override
    public boolean canHandle(PokerHand unaMano) {
        ConjuntoDeNaipes naipesRepetidos = unaMano.naipesRepetidos();
        return naipesRepetidos.cantidad() == 3;
    }

    @Override
    public TipoDeJugada armarJugada(ConjuntoDeNaipes unosNaipes) {
        return new JugadaPierna(unosNaipes);
    }
}
