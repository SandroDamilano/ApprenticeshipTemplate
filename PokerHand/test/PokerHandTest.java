import main.Carta;
import main.PokerHand;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PokerHandTest {

    @Test
    public void unaCartaNumericaLeGanaAOtraDeMenorValor(){
        Carta sieteDeDiamantes = new Carta(7, 'd');
        Carta ochoDeTrebol = new Carta(8, 'c');
        assert (ochoDeTrebol.esMayorQue(sieteDeDiamantes));
    }

    @Test
    public void unaJLeGanaAOtraCartaNumerica(){
        Carta jotaDeDiamantes = new Carta("J", 'd');
        Carta ochoDeTrebol = new Carta(8, 'c');
        assert (jotaDeDiamantes.esMayorQue(ochoDeTrebol));
    }

    @Test
    public void unaQLeGanaAOtraCartaT(){
        Carta diezDeDiamantes = new Carta("T", 'd');
        Carta quDeTrebol = new Carta("Q", 'c');
        assert (quDeTrebol.esMayorQue(diezDeDiamantes));
    }

    @Test
    public void unaKLeGanaAOtraCartaNumerica(){
        Carta kaDeDiamantes = new Carta("K", 'd');
        Carta nueveDeTrebol = new Carta(9, 'c');
        assert (kaDeDiamantes.esMayorQue(nueveDeTrebol));
    }

    @Test
    public void unAsLeGanaAOtraCartaK(){
        Carta kaDeDiamantes = new Carta("K", 'd');
        Carta asDeCorazones = new Carta("A", 'h');
        assert (asDeCorazones.esMayorQue(kaDeDiamantes));
    }

    @Test
    public void unaCartaNoLeGanaASiMisma(){
        Carta asDeCorazones = new Carta("A", 'h');
        assert (!asDeCorazones.esMayorQue(asDeCorazones));
    }

    @Test
    public void unaManoLeGanaAOtraPorHighestCard(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Carta(2,'s'), new Carta(5,'d'), new Carta(9,'h'), new Carta(8,'s'), new Carta(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Carta(2,'s'), new Carta(5,'d'), new Carta(8,'h'), new Carta(6,'s'), new Carta(7,'c')));

        assert(manoBlanca.leGanaA(manoNegra));
    }

    @Test
    public void cuandoLasHighestCardsSonIgualesGanaLaManoQueTengaLaSegundaHighestCard(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Carta(2,'s'), new Carta(5,'d'), new Carta("Q",'h'), new Carta(8,'s'), new Carta(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Carta(2,'s'), new Carta(5,'d'), new Carta("Q",'h'), new Carta(6,'s'), new Carta(7,'c')));

        assert(manoBlanca.leGanaA(manoNegra));
    }

    @Test
    public void unParLeGanaAUnaHighCard(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Carta(2,'s'), new Carta(5,'d'), new Carta(9,'h'), new Carta(8,'s'), new Carta(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Carta(2,'s'), new Carta(2,'d'), new Carta(8,'h'), new Carta(6,'s'), new Carta(7,'c')));

        assert(manoNegra.leGanaA(manoBlanca));
    }

    @Test
    public void unParLeGanaAOtroParSiEsDeValoresMasAltos(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Carta(5,'s'), new Carta(5,'d'), new Carta(6,'h'), new Carta(8,'s'), new Carta(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Carta(2,'s'), new Carta(2,'d'), new Carta("K",'h'), new Carta(6,'s'), new Carta(7,'c')));

        assert(manoBlanca.leGanaA(manoNegra));
    }

    @Test
    public void cuandoLosParesTienenElMismoValorGanaLaManoConLaCartaMasAlta(){
        PokerHand manoBlanca = new PokerHand(Arrays.asList(new Carta(5,'s'), new Carta(5,'d'), new Carta(6,'h'), new Carta(8,'s'), new Carta(7,'c')));
        PokerHand manoNegra = new PokerHand(Arrays.asList(new Carta(2,'s'), new Carta(2,'d'), new Carta("K",'h'), new Carta(6,'s'), new Carta(7,'c')));

        assert(manoBlanca.leGanaA(manoNegra));
    }
}
