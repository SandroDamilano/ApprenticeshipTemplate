package jugadas;

import main.ConjuntoDeNaipes;
import main.PokerHand;

/**
 * Created by sandro on 28/04/17.
 */
public class JugadaPierna implements TipoDeJugada {

    ConjuntoDeNaipes pierna;
    JugadaNaipeMasAlto restoDeLasCartas;

    public JugadaPierna(ConjuntoDeNaipes unosNaipes){
        pierna = unosNaipes.naipesRepetidos();
        restoDeLasCartas = new JugadaNaipeMasAlto(unosNaipes.sin(pierna));
    }

    @Override
    public boolean leGanaA(TipoDeJugada otraJugada) {
        return otraJugada.pierdeContraPierna(this);
    }

    @Override
    public boolean pierdeContraParDoble(JugadaParDoble otraJugada) {
        return false;
    }

    @Override
    public boolean pierdeContraPar(JugadaPar otraJugada) {
        return false;
    }

    @Override
    public boolean pierdeContraCartaMasAlta(JugadaNaipeMasAlto otraJugada) {
        return false;
    }

    @Override
    public boolean pierdeContraPierna(JugadaPierna otraJugada) {
        return otraJugada.pierna.alguno().esMayorQue(pierna.alguno());
    }
}
