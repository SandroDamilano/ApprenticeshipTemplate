package jugadas;

import main.Carta;
import main.PokerHand;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sandro on 12/04/17.
 */
public class JugadaCartaMasAlta  implements TipoDeJugada {

    List<Carta> cartas;

    public JugadaCartaMasAlta(List<Carta> unasCartas){
        cartas = unasCartas;
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
    public boolean pierdeContraPar(JugadaPar otraJugada) {
        return true;
    }

    @Override
    public boolean pierdeContraCartaMasAlta(JugadaCartaMasAlta otraJugada) {
        if(this.cartaMasAlta().tieneElMismoValorQue(otraJugada.cartaMasAlta())){
            return otraJugada.sinLaMasAlta().leGanaA(this.sinLaMasAlta());
        }

        return otraJugada.cartaMasAlta().esMayorQue(this.cartaMasAlta());
    }

    private Carta cartaMasAlta(){
        return cartas.stream()
                .filter(carta -> cartas.stream()
                        .filter(unaCarta -> !unaCarta.equals(carta))
                        .allMatch(cartaMenor -> carta.esMayorQue(cartaMenor)))
                .findFirst().get();
    }

    private JugadaCartaMasAlta sinLaMasAlta(){
        Stream<Carta> nuevasCartas = cartas.stream().filter(carta -> !carta.equals(this.cartaMasAlta()));
        return new JugadaCartaMasAlta(nuevasCartas.collect(Collectors.toList()));
    }

}
