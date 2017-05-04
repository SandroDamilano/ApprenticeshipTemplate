/**
 * Created by sandro on 04/05/17.
 */
public interface FacturadorDeLlamada {
    boolean esAplicablePara(Llamada unaLlamada);

    Double costoDe(Llamada unaLlamada);
}
