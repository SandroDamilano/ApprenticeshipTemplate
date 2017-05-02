import org.joda.time.Interval;

import java.time.DayOfWeek;

/**
 * Created by sandro on 02/05/17.
 */
public class LlamadaLocal {

    private Interval intervaloDeLlamada;

    public LlamadaLocal(Interval unIntervaloDeLlamada) {
        intervaloDeLlamada = unIntervaloDeLlamada;
    }

    public Double costo() {

        if(intervaloDeLlamada.getEnd().getHourOfDay() <= 19
                && intervaloDeLlamada.getEnd().getHourOfDay() >= 8
                && intervaloDeLlamada.getEnd().getDayOfWeek() < 6)
            return intervaloDeLlamada.toPeriod().getMinutes() * 0.2;
        else
            return intervaloDeLlamada.toPeriod().getMinutes() * 0.1;
    }
}
