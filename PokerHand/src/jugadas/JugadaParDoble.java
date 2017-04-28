package jugadas;

import main.ConjuntoDeNaipes;
import main.Naipe;
import main.PokerHand;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sandro on 12/04/17.
 */
public class JugadaParDoble implements TipoDeJugada {

    ConjuntoDeNaipes parAlto;
    JugadaPar restoDeLasCartas;


    public JugadaParDoble(ConjuntoDeNaipes unosNaipes){
        Naipe naipeConParMasAlto = unosNaipes.naipesRepetidos().naipeMasAlto();
        parAlto = unosNaipes.naipesDelMismoValorQue(naipeConParMasAlto);
        restoDeLasCartas = new JugadaPar(unosNaipes.sin(parAlto));
    }

    @Override
    public boolean canHandle(PokerHand unaMano){
        ConjuntoDeNaipes naipesRepetidos = unaMano.naipesRepetidos();
        Naipe unNaipe = naipesRepetidos.alguno();
        return naipesRepetidos.cantidad() == 4 &&
                naipesRepetidos.naipesDelMismoValorQue(unNaipe).cantidad() != 4;
    }

    @Override
    public boolean leGanaA(TipoDeJugada otraJugada) {
        return otraJugada.pierdeContraParDoble(this);
    }

    @Override
    public boolean pierdeContraPar(JugadaPar otraJugada) {
        return false;
    }

    @Override
    public boolean pierdeContraParDoble(JugadaParDoble otraJugada) {
        if(parAlto.alguno().tieneElMismoValorQue(otraJugada.parAlto.alguno())){
            return restoDeLasCartas.pierdeContraPar(otraJugada.restoDeLasCartas);
        }

        return otraJugada.parAlto.alguno().esMayorQue(parAlto.alguno());
    }

    @Override
    public boolean pierdeContraCartaMasAlta(JugadaNaipeMasAlto otraJugada) {
        return false;
    }

}
