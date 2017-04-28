package jugadas;

import main.ConjuntoDeNaipes;
import main.Naipe;
import main.PokerHand;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sandro on 12/04/17.
 */
public class JugadaNaipeMasAlto implements TipoDeJugada {

    ConjuntoDeNaipes naipes;

    public JugadaNaipeMasAlto(ConjuntoDeNaipes unosNaipes){
        naipes = unosNaipes;
    }

    @Override
    public boolean canHandle(PokerHand unaMano){
        return true;
    }

    @Override
    public boolean leGanaA(TipoDeJugada otraJugada) {
        return otraJugada.pierdeContraCartaMasAlta(this);
    }

    @Override
    public boolean pierdeContraParDoble(JugadaParDoble otraJugada) {
        return true;
    }

    @Override
    public boolean pierdeContraPar(JugadaPar otraJugada) {
        return true;
    }

    @Override
    public boolean pierdeContraCartaMasAlta(JugadaNaipeMasAlto otraJugada) {
        if(this.naipeMasAlto().tieneElMismoValorQue(otraJugada.naipeMasAlto())){
            return otraJugada.sinElMasAlto().leGanaA(this.sinElMasAlto());
        }

        return otraJugada.naipeMasAlto().esMayorQue(this.naipeMasAlto());
    }

    private Naipe naipeMasAlto(){
        return naipes.naipeMasAlto();
    }

    private JugadaNaipeMasAlto sinElMasAlto(){
        return new JugadaNaipeMasAlto(naipes.sinElMasAlto());
    }

}
