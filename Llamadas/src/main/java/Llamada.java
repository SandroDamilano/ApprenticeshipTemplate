import org.joda.time.Interval;

/**
 * Created by sandro on 04/05/17.
 */
public class Llamada {

    protected Telefono origen;
    protected Telefono destino;
    protected Interval intervaloDeLlamada;

    public Llamada(Telefono unOrigen, Telefono unDestino, Interval unIntervaloDeLlamada) {
        intervaloDeLlamada = unIntervaloDeLlamada;
        origen = unOrigen;
        destino = unDestino;
    }

    public Integer duracionEnMinutos() {
        return intervaloDeLlamada.toPeriod().getMinutes();
    }

    public boolean esNacional() {
        return origen.esDelMismoPaisQue(destino) && !origen.esDelMismoAreaQue(destino);
    }

    public boolean esInternacional() {
        return !origen.esDelMismoPaisQue(destino);
    }

    public Telefono destino(){
        return destino;
    }
}
