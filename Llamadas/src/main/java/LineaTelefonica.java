import org.joda.time.YearMonth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sandro on 02/05/17.
 */
public class LineaTelefonica {

    List<LlamadaNacional> llamadasNacionales = new ArrayList<>();

    public void agregarLlamada(LlamadaNacional unaLlamadaNacional) {
        llamadasNacionales.add(unaLlamadaNacional);
    }

    public List<LlamadaNacional> llamadasNacionalesDelMes(YearMonth unMesDeAnio) {
        return llamadasNacionales.stream()
                .filter(llamada -> llamada.ocurrioEnElMesDeAnio(unMesDeAnio))
                .collect(Collectors.toList());
    }
}
