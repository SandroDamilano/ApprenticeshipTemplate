package main;

import main.Llamada;
import org.joda.time.YearMonth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sandro on 02/05/17.
 */
public class LineaTelefonica {

    List<Llamada> llamadas = new ArrayList<>();

    public void agregarLlamada(Llamada unaLlamada) {
        llamadas.add(unaLlamada);
    }

    public List<Llamada> llamadasDelMes(YearMonth unMesDeAnio) {
        return llamadas.stream()
                .filter(llamada -> llamada.ocurrioEnElMesDeAnio(unMesDeAnio))
                .collect(Collectors.toList());
    }
}
