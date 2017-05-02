import org.joda.time.YearMonth;

import java.util.List;

/**
 * Created by sandro on 02/05/17.
 */
public class FacturaTelefonica {

    LineaTelefonica lineaTelefonica;
    YearMonth mesDeAnio;

    public FacturaTelefonica(YearMonth unMesDeAnio, LineaTelefonica unaLineaTelefonica){
        mesDeAnio = unMesDeAnio;
        lineaTelefonica = unaLineaTelefonica;
    }

    public Double monto() {
        List<LlamadaNacional> llamadasNacionalesDelMes = lineaTelefonica.llamadasNacionalesDelMes(mesDeAnio);
        Double costoDeLlamadas = llamadasNacionalesDelMes.stream().mapToDouble(LlamadaNacional::costo).sum();
        return 10 + costoDeLlamadas;
    }
}
