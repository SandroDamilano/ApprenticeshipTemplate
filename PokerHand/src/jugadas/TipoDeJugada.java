package jugadas;

import main.PokerHand;

/**
 * Created by sandro on 12/04/17.
 */
public interface TipoDeJugada {

//    boolean canHandle(PokerHand unaMano);
    boolean leGanaA(TipoDeJugada otraJugada);

    boolean pierdeContraParDoble(JugadaParDoble otraJugada);
    boolean pierdeContraPar(JugadaPar otraJugada);
    boolean pierdeContraCartaMasAlta(JugadaNaipeMasAlto otraJugada);
    boolean pierdeContraPierna(JugadaPierna otraJugada);
}
