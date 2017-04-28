package main;

import jugadas.TipoDeJugada;

import java.util.List;
import java.util.stream.Collectors;

public class PokerHand {

    protected ConjuntoDeNaipes naipes;

//    protected Naipe naipe1;
//    protected Naipe naipe2;
//    protected Naipe naipe3;
//    protected Naipe naipe4;
//    protected Naipe naipe5;

    public PokerHand(List<Naipe> unosNaipes){
        naipes = new ConjuntoDeNaipes(unosNaipes);
    }

//    public PokerHand(Naipe unNaipe1, Naipe unNaipe2, Naipe unNaipe3, Naipe unNaipe4, Naipe unNaipe5){
//        naipe1 = unNaipe1;
//        naipe2 = unNaipe2;
//        naipe3 = unNaipe3;
//        naipe4 = unNaipe4;
//        naipe5 = unNaipe5;
//    }

    public boolean leGanaA(PokerHand otraMano){
        return this.jugada().leGanaA(otraMano.jugada());
    }

    public ConjuntoDeNaipes naipes(){
        return naipes;
    }

//    public List<Naipe> naipes(){
//        return Arrays.asList(naipe1, naipe2, naipe3, naipe4, naipe5);
//    }

    public TipoDeJugada jugada(){
        return new ProveedorDeJugadas().tipoDe(this);
    }

    public ConjuntoDeNaipes naipesRepetidos(){
        return naipes.naipesRepetidos();
    }

}
