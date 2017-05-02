/**
 * Created by sandro on 02/05/17.
 */
public class LlamadaInternacional {

    private Integer minutos;
    private String region;

    public LlamadaInternacional(Integer unosMinutos, String unaRegion) {
        minutos = unosMinutos;
        region = unaRegion;
    }

    public Double costo() {

        if(region == "Sudamerica")
            return 0.50 * minutos;

        if(region == "Norte-America" || region == "Europa")
            return 0.70 * minutos;

        return 1.5 * minutos;
    }
}
