import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by sandro on 04/05/17.
 */
public class ReglaDeFeriadoConIntervalo implements ReglaDeFeriado{

    private IntervaloDeTiempo intervalo;
    private LocalDate fecha;

    public ReglaDeFeriadoConIntervalo(LocalDate unaFecha, IntervaloDeTiempo unIntervalo){
        fecha = unaFecha;
        intervalo = unIntervalo;

    }

    @Override
    public boolean esFeriado(LocalDate unaFecha) {
        return unaFecha.equals(fecha) && intervalo.contains(unaFecha);
    }
}
