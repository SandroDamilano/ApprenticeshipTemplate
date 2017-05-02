/**
 * Created by sandro on 02/05/17.
 */
public class LlamadaInternacional {

    private Integer minutos;

    public LlamadaInternacional(Integer unosMinutos, String region) {
        minutos = unosMinutos;
    }

    public Double costo() {
        return 0.50 * minutos;
    }
}
