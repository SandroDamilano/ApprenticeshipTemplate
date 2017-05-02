import org.joda.time.Interval;

/**
 * Created by sandro on 02/05/17.
 */
public class LlamadaInternacional {

    private Interval intervaloDeLlamada;
    private String region;

    public LlamadaInternacional(Interval unIntervaloDeLlamada, String unaRegion) {
        intervaloDeLlamada = unIntervaloDeLlamada;
        region = unaRegion;
    }

    public Double costo() {

        if(region == "Sudamerica")
            return 0.50 * duracionEnMinutos();

        if(region == "Norte-America" || region == "Europa")
            return 0.70 * duracionEnMinutos();

        return 1.5 * duracionEnMinutos();
    }

    private Integer duracionEnMinutos() {
        return intervaloDeLlamada.toPeriod().getMinutes();
    }
}
