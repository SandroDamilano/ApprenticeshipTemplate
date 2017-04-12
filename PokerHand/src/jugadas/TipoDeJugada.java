package jugadas;

import main.PokerHand;

/**
 * Created by sandro on 12/04/17.
 */
public interface TipoDeJugada {

    boolean canHandle(PokerHand unaMano);
    boolean leGanaA(TipoDeJugada otraJugada);

    boolean pierdeContraPar(JugadaPar otraJugada);
    boolean pierdeContraCartaMasAlta(JugadaCartaMasAlta otraJugada);
}
