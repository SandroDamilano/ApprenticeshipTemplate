import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.YearMonth;

/**
 * Created by sandro on 02/05/17.
 */
public class LlamadaNacional {

    private Interval intervaloDeLlamada;

    public LlamadaNacional(Interval unIntervaloDeLlamada) {
        intervaloDeLlamada = unIntervaloDeLlamada;
    }

    public Double costo() {
        return 0.3 * duracionEnMinutos();
    }

    private Integer duracionEnMinutos() {
        return intervaloDeLlamada.toPeriod().getMinutes();
    }

    public boolean ocurrioEnElMesDeAnio(YearMonth unMesDeAnio) {
        DateTime finDelaLlamada = intervaloDeLlamada.getEnd();
        return finDelaLlamada.getYear() == unMesDeAnio.getYear()
                && finDelaLlamada.getMonthOfYear() == unMesDeAnio.getMonthOfYear();
    }
}
