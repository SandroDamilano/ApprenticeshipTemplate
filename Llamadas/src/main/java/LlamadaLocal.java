import org.joda.time.Interval;

/**
 * Created by sandro on 02/05/17.
 */
public class LlamadaLocal {

    private Interval intervaloDeLlamada;

    public LlamadaLocal(Interval unIntervaloDeLlamada) {
        intervaloDeLlamada = unIntervaloDeLlamada;
    }

    public Double costo() {
        if(esHoraPico() && esDiaHabil())
            return intervaloDeLlamada.toPeriod().getMinutes() * 0.2;
        else
            return intervaloDeLlamada.toPeriod().getMinutes() * 0.1;
    }

    private boolean esDiaHabil() {
        return intervaloDeLlamada.getEnd().getDayOfWeek() < 6;
    }

    private boolean esHoraPico() {
        return intervaloDeLlamada.getEnd().getHourOfDay() <= 19
                && intervaloDeLlamada.getEnd().getHourOfDay() >= 8;
    }
}
