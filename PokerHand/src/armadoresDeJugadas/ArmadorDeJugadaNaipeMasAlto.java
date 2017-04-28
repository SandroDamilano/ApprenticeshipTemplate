package armadoresDeJugadas;

import jugadas.JugadaNaipeMasAlto;
import jugadas.TipoDeJugada;
import main.ConjuntoDeNaipes;
import main.PokerHand;

/**
 * Created by sandro on 21/04/17.
 */
public class ArmadorDeJugadaNaipeMasAlto implements ArmadorDeJugadas {
    @Override
    public boolean canHandle(PokerHand unaMano) {
        return true;
    }

    @Override
    public TipoDeJugada armarJugada(ConjuntoDeNaipes unosNaipes) {
        return new JugadaNaipeMasAlto(unosNaipes);
    }
}
