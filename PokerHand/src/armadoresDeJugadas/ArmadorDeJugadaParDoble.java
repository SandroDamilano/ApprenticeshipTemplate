package armadoresDeJugadas;

import jugadas.JugadaParDoble;
import jugadas.TipoDeJugada;
import main.ConjuntoDeNaipes;
import main.Naipe;
import main.PokerHand;

/**
 * Created by sandro on 21/04/17.
 */
public class ArmadorDeJugadaParDoble implements ArmadorDeJugadas {
    @Override
    public boolean canHandle(PokerHand unaMano) {
        ConjuntoDeNaipes naipesRepetidos = unaMano.naipesRepetidos();
//        Naipe unNaipe = naipesRepetidos.alguno();
        return naipesRepetidos.cantidad() == 4 &&
//                naipesRepetidos.naipesDelMismoValorQue(unNaipe).cantidad() != 4;
                    !naipesRepetidos.tienenElMismoValor();
    }

    @Override
    public TipoDeJugada armarJugada(ConjuntoDeNaipes unosNaipes) {
        return new JugadaParDoble(unosNaipes);
    }
}
