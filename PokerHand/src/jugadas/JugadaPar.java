package jugadas;

import main.ConjuntoDeNaipes;
import main.Naipe;
import main.PokerHand;

import java.util.List;

/**
 * Created by sandro on 12/04/17.
 */
public class JugadaPar implements TipoDeJugada {

    ConjuntoDeNaipes par;
    JugadaNaipeMasAlto restoDeLasCartas;


    public JugadaPar(ConjuntoDeNaipes unosNaipes){
        par = unosNaipes.naipesRepetidos();
        restoDeLasCartas = new JugadaNaipeMasAlto(unosNaipes.naipesSinRepetir());
    }

    @Override
    public boolean leGanaA(TipoDeJugada otraJugada) {
        return otraJugada.pierdeContraPar(this);
    }

    @Override
    public boolean pierdeContraPierna(JugadaPierna otraJugada) {
        return true;
    }

    @Override
    public boolean pierdeContraParDoble(JugadaParDoble otraJugada) {
        return true;
    }

    @Override
    public boolean pierdeContraPar(JugadaPar otraJugada) {
        if(par.alguno().tieneElMismoValorQue(otraJugada.par.alguno())){
            return otraJugada.restoDeLasCartas.leGanaA(restoDeLasCartas);
        }

        return otraJugada.par.alguno().esMayorQue(par.alguno());
    }

    @Override
    public boolean pierdeContraCartaMasAlta(JugadaNaipeMasAlto otraJugada) {
        return false;
    }

}
