/**
 * Created by sandro on 02/05/17.
 */
public class LlamadaNacional {

    private Integer minutos;

    public LlamadaNacional(Integer unosMinutos) {
        minutos = unosMinutos;
    }

    public Double costo() {
        return 0.3 * minutos;
    }
}
