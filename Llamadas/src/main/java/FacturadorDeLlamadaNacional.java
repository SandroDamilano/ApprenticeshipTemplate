/**
 * Created by sandro on 04/05/17.
 */
public class FacturadorDeLlamadaNacional implements FacturadorDeLlamada {

    @Override
    public boolean esAplicablePara(Llamada unaLlamada) {
        return unaLlamada.esNacional();
    }

    @Override
    public Double costoDe(Llamada unaLlamada) {
        return 0.3 * unaLlamada.duracionEnMinutos();
    }
}
