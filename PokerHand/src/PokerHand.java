import java.util.List;

public class PokerHand {

    protected List<Carta> cartas;

    public PokerHand(List<Carta> unasCartas){
        cartas = unasCartas;
    }

    public boolean leGanaA(PokerHand otraMano){
        return maximaCarta().esMayorQue(otraMano.maximaCarta());
    }

    protected Carta maximaCarta(){
        return cartas().stream()
                .filter(carta -> cartas.stream()
                        .filter(unaCarta -> !unaCarta.equals(carta))
                        .allMatch(cartaMenor -> carta.esMayorQue(cartaMenor)))
                .findFirst().get();
    }

    public List<Carta> cartas(){
        return cartas;
    }
}
