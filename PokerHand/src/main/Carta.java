package main;

import valoresdeCartas.ValorDeCarta;
import valoresdeCartas.ValorNumerico;

public class Carta {

    protected ValorDeCarta valor;
    protected Character palo;

    public Carta(Integer unValor, Character unPalo){
        valor = new ValorNumerico(unValor);
        palo = unPalo;
    }

    public Carta(String unValor, Character unPalo){
        valor = new ProveedorDeValoresDeCartas().obtenerValorPara(unValor);
        palo = unPalo;
    }

    public boolean esMayorQue(Carta otraCarta){
        return valor.esMayorQue(otraCarta.valor);
    }

    public boolean tieneElMismoValorQue(Carta otraCarta){
        return !this.esMayorQue(otraCarta) && !otraCarta.esMayorQue(this);
    }

    public ValorDeCarta valor(){
        return valor;
    }
}
