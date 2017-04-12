package main;

import jugadas.TipoDeJugada;

import java.util.List;

public class PokerHand {

    protected List<Carta> cartas;

    public PokerHand(List<Carta> unasCartas){
        cartas = unasCartas;
    }

    public boolean leGanaA(PokerHand otraMano){
        return this.jugada().leGanaA(otraMano.jugada());
    }

    public List<Carta> cartas(){
        return cartas;
    }

    public TipoDeJugada jugada(){
        return new ProveedorDeJugadas().tipoDe(this);
    }

}
