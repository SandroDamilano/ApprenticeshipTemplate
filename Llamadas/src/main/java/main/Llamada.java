package main;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.YearMonth;

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

    public boolean esLocal() {
        return origen.esDelMismoPaisQue(destino) && origen.esDelMismoAreaQue(destino);
    }

    public boolean esEnDiaHabil() {
        return intervaloDeLlamada.getEnd().getDayOfWeek() < 6;
    }

    public boolean esEnHoraPico() {
        return intervaloDeLlamada.getEnd().getHourOfDay() <= 19
                && intervaloDeLlamada.getEnd().getHourOfDay() >= 8;
    }

    public Telefono destino(){
        return destino;
    }

    public boolean ocurrioEnElMesDeAnio(YearMonth unMesDeAnio) {
        DateTime finDelaLlamada = intervaloDeLlamada.getEnd();
        return finDelaLlamada.getYear() == unMesDeAnio.getYear()
                && finDelaLlamada.getMonthOfYear() == unMesDeAnio.getMonthOfYear();
    }
}
