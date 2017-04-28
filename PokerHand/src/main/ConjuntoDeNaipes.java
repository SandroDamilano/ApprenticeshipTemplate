package main;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sandro on 18/04/17.
 */
public class ConjuntoDeNaipes {

    protected List<Naipe> naipes;

    public ConjuntoDeNaipes(List<Naipe> unosNaipes){
        naipes = unosNaipes;
    }

    public ConjuntoDeNaipes naipesRepetidos(){
        return new ConjuntoDeNaipes(naipes.stream()
                .filter(unaCarta -> naipes.stream()
                        .filter(carta -> !carta.equals(unaCarta))
                        .anyMatch(otraCarta -> otraCarta.tieneElMismoValorQue(unaCarta)))
                .collect(Collectors.toList()));
    }

    public ConjuntoDeNaipes naipesSinRepetir(){
        return new ConjuntoDeNaipes(naipes.stream()
                .filter(carta -> !this.naipesRepetidos().contiene(carta))
                .collect(Collectors.toList()));
    }

    public Naipe naipeMasAlto(){
        return naipes.stream()
                .filter(naipe -> naipes.stream()
                        .filter(unNaipe -> !unNaipe.tieneElMismoValorQue(naipe))
                        .allMatch(naipeMenor -> naipe.esMayorQue(naipeMenor)))
                .findFirst().get();
    }

    public ConjuntoDeNaipes sinElMasAlto(){
        return new ConjuntoDeNaipes(naipes.stream()
                .filter(carta -> !carta.equals(this.naipeMasAlto()))
                .collect(Collectors.toList()));
    }

    public ConjuntoDeNaipes naipesDelMismoValorQue(Naipe naipeDeReferencia){
        return new ConjuntoDeNaipes(naipes.stream()
                .filter(unNaipe -> unNaipe.tieneElMismoValorQue(naipeDeReferencia))
                .collect(Collectors.toList()));
    }

    public ConjuntoDeNaipes sin(ConjuntoDeNaipes naipesAQuitar){
        return new ConjuntoDeNaipes(naipes.stream()
                .filter(unNaipe -> !naipesAQuitar.contiene(unNaipe))
                .collect(Collectors.toList()));
    }

    public boolean tienenElMismoValor(){
        return naipes.size() > 1
                && naipes.stream()
                        .allMatch(naipe -> naipe.tieneElMismoValorQue(naipes.get(0)));
    }

    protected boolean contiene(Naipe unNaipe){
        return naipes.contains(unNaipe);
    }

    public Integer cantidad(){
        return naipes.size();
    }

    public Naipe alguno(){
        return naipes.get(0);
    }
}
