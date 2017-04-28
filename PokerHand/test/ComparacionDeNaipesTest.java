import main.Naipe;
import org.junit.jupiter.api.Test;

/**
 * Created by sandro on 17/04/17.
 */
public class ComparacionDeNaipesTest {
    @Test
    public void unaCartaNumericaLeGanaAOtraDeMenorValor(){
        Naipe sieteDeDiamantes = new Naipe(7, 'd');
        Naipe ochoDeTrebol = new Naipe(8, 'c');
        assert (ochoDeTrebol.esMayorQue(sieteDeDiamantes));
    }

    @Test
    public void unaJLeGanaAOtraCartaNumerica(){
        Naipe jotaDeDiamantes = new Naipe("J", 'd');
        Naipe ochoDeTrebol = new Naipe(8, 'c');
        assert (jotaDeDiamantes.esMayorQue(ochoDeTrebol));
    }

    @Test
    public void unaQLeGanaAOtraCartaT(){
        Naipe diezDeDiamantes = new Naipe("T", 'd');
        Naipe quDeTrebol = new Naipe("Q", 'c');
        assert (quDeTrebol.esMayorQue(diezDeDiamantes));
    }

    @Test
    public void unaKLeGanaAOtraCartaNumerica(){
        Naipe kaDeDiamantes = new Naipe("K", 'd');
        Naipe nueveDeTrebol = new Naipe(9, 'c');
        assert (kaDeDiamantes.esMayorQue(nueveDeTrebol));
    }

    @Test
    public void unAsLeGanaAOtraCartaK(){
        Naipe kaDeDiamantes = new Naipe("K", 'd');
        Naipe asDeCorazones = new Naipe("A", 'h');
        assert (asDeCorazones.esMayorQue(kaDeDiamantes));
    }

    @Test
    public void unaCartaNoLeGanaASiMisma(){
        Naipe asDeCorazones = new Naipe("A", 'h');
        assert (!asDeCorazones.esMayorQue(asDeCorazones));
    }
}
