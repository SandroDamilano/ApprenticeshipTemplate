package main;

import valoresDeNaipes.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sandro on 10/04/17.
 */
public class ProveedorDeValoresDeNaipes {

    protected List<ValorNoNumericoDeNaipe> valoresDeCartas;

    public ProveedorDeValoresDeNaipes(){
        valoresDeCartas = Arrays.asList(new ValorA(), new ValorK(), new ValorQ(), new ValorJ(), new ValorT());
    }

    public ValorNoNumericoDeNaipe obtenerValorPara(String unValor) {
        return valoresDeCartas.stream().filter(valor -> valor.canHandle(unValor)).findFirst().get();
    }
}
