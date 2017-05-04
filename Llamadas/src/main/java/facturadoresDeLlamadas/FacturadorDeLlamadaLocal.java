package facturadoresDeLlamadas;

import facturadoresDeLlamadas.FacturadorDeLlamada;
import main.Llamada;

/**
 * Created by sandro on 04/05/17.
 */
public class FacturadorDeLlamadaLocal implements FacturadorDeLlamada {

    @Override
    public boolean esAplicablePara(Llamada unaLlamada) {
        return unaLlamada.esLocal();
    }

    @Override
    public Double costoDe(Llamada unaLlamada) {
        if(unaLlamada.esEnDiaHabil() && unaLlamada.esEnHoraPico())
            return unaLlamada.duracionEnMinutos() * 0.2;
        else
            return unaLlamada.duracionEnMinutos() * 0.1;
    }
}
