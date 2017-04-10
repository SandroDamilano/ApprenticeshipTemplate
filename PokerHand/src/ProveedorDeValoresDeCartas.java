import valoresdeCartas.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sandro on 10/04/17.
 */
public class ProveedorDeValoresDeCartas {

    protected List<ValorNoNumericoDeCarta> valoresDeCartas;

    public ProveedorDeValoresDeCartas(){
        valoresDeCartas = Arrays.asList(new ValorA(), new ValorK(), new ValorQ(), new ValorJ(), new ValorT());
    }

    public ValorNoNumericoDeCarta obtenerValorPara(String unValor) {
        return valoresDeCartas.stream().filter(valor -> valor.canHandle(unValor)).findFirst().get();
    }

//    public ValorNoNumericoDeCarta obtenerValorPara(Integer unValor) {
//        return valoresDeCartas.stream().filter(valor -> valor.canHandle(unValor)).findFirst().get();
//    }
}
