package main;

import valoresDeNaipes.ValorDeNaipe;
import valoresDeNaipes.ValorNumericoDeNaipe;

public class Naipe {

    protected ValorDeNaipe valor;
    protected Character palo;

    public Naipe(Integer unValor, Character unPalo){
        valor = new ValorNumericoDeNaipe(unValor);
        palo = unPalo;
    }

    public Naipe(String unValor, Character unPalo){
        valor = new ProveedorDeValoresDeNaipes().obtenerValorPara(unValor);
        palo = unPalo;
    }

    public boolean esMayorQue(Naipe otroNaipe){
        return valor.esMayorQue(otroNaipe.valor);
    }

    public boolean tieneElMismoValorQue(Naipe otroNaipe){
        return !this.esMayorQue(otroNaipe) && !otroNaipe.esMayorQue(this);
    }

    public ValorDeNaipe valor(){
        return valor;
    }
}
