import main.Naipe;
import main.PokerHand;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PokerHandTest {

    @Test
    public void unaManoLeGanaAOtraPorHighestCard(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Naipe(2,'s'), new Naipe(5,'d'), new Naipe(9,'h'), new Naipe(8,'s'), new Naipe(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Naipe(2,'s'), new Naipe(5,'d'), new Naipe(8,'h'), new Naipe(6,'s'), new Naipe(7,'c')));

        assert(manoBlanca.leGanaA(manoNegra));
    }

    @Test
    public void cuandoLasHighestCardsSonIgualesGanaLaManoQueTengaLaSegundaHighestCard(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Naipe(2,'s'), new Naipe(5,'d'), new Naipe("Q",'h'), new Naipe(8,'s'), new Naipe(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Naipe(2,'s'), new Naipe(5,'d'), new Naipe("Q",'h'), new Naipe(6,'s'), new Naipe(7,'c')));

        assert(manoBlanca.leGanaA(manoNegra));
    }

    @Test
    public void unParLeGanaAUnaHighCard(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Naipe(2,'s'), new Naipe(5,'d'), new Naipe(9,'h'), new Naipe(8,'s'), new Naipe(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Naipe(2,'s'), new Naipe(2,'d'), new Naipe(8,'h'), new Naipe(6,'s'), new Naipe(7,'c')));

        assert(manoNegra.leGanaA(manoBlanca));
    }

    @Test
    public void unParLeGanaAOtroParSiEsDeValoresMasAltos(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Naipe(5,'s'), new Naipe(5,'d'), new Naipe(6,'h'), new Naipe(8,'s'), new Naipe(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Naipe(2,'s'), new Naipe(2,'d'), new Naipe("K",'h'), new Naipe(6,'s'), new Naipe(7,'c')));

        assert(manoBlanca.leGanaA(manoNegra));
    }

    @Test
    public void cuandoLosParesTienenElMismoValorGanaLaManoConLaCartaMasAlta(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Naipe(5,'s'), new Naipe(5,'d'), new Naipe(6,'h'), new Naipe(8,'s'), new Naipe(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Naipe(2,'s'), new Naipe(2,'d'), new Naipe("K",'h'), new Naipe(6,'s'), new Naipe(7,'c')));

        assert(manoBlanca.leGanaA(manoNegra));
    }

    @Test
    public void unParDobleLeGanaAUnPar(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Naipe("A",'s'), new Naipe("A",'d'), new Naipe(6,'h'), new Naipe(8,'s'), new Naipe(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Naipe(2,'s'), new Naipe(2,'d'), new Naipe("K",'h'), new Naipe(6,'s'), new Naipe(6,'c')));

        assert(manoNegra.leGanaA(manoBlanca));
    }
}
