package jugadas;

import main.Carta;
import main.PokerHand;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sandro on 12/04/17.
 */
public class JugadaPar implements TipoDeJugada {

    List<Carta> par;
    JugadaCartaMasAlta restoDeLasCartas;


    public JugadaPar(PokerHand unaMano){
        List<Carta> cartas = unaMano.cartas();
        par = cartas.stream()
                .filter(unaCarta -> cartas.stream()
                                        .filter(carta -> !carta.equals(unaCarta))
                                        .anyMatch(otraCarta -> otraCarta.tieneElMismoValorQue(unaCarta)))
                .collect(Collectors.toList());
        restoDeLasCartas = new JugadaCartaMasAlta(
                cartas.stream()
                        .filter(carta -> !par.contains(carta))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public boolean canHandle(PokerHand unaMano){
        return unaMano.cartas().stream()
                .anyMatch(carta -> unaMano.cartas().stream()
                        .filter(unaCarta -> !unaCarta.equals(carta))
                        .anyMatch(otraCarta -> carta.tieneElMismoValorQue(otraCarta)));
    }

    @Override
    public boolean leGanaA(TipoDeJugada otraJugada) {
        return otraJugada.pierdeContraPar(this);
    }

    @Override
    public boolean pierdeContraPar(JugadaPar otraJugada) {
        if(par.get(0).tieneElMismoValorQue(otraJugada.par.get(0))){
            return otraJugada.restoDeLasCartas.leGanaA(restoDeLasCartas);
        }

        return otraJugada.par.get(0).esMayorQue(par.get(0));
    }

    @Override
    public boolean pierdeContraCartaMasAlta(JugadaCartaMasAlta otraJugada) {
        return false;
    }

}
