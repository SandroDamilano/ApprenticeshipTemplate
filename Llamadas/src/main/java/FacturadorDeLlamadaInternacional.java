import java.util.List;
import java.util.Map;

/**
 * Created by sandro on 04/05/17.
 */
public class FacturadorDeLlamadaInternacional implements FacturadorDeLlamada {

    protected Map<String, List<String>> listadoDeCodigosDePaisPorRegion;

    public FacturadorDeLlamadaInternacional(Map<String, List<String>> unListadoDeCodigosDePaisPorRegion){
        listadoDeCodigosDePaisPorRegion = unListadoDeCodigosDePaisPorRegion;
    }

    @Override
    public boolean esAplicablePara(Llamada unaLlamada) {
        return unaLlamada.esInternacional();
    }

    @Override
    public Double costoDe(Llamada unaLlamada) {
        if(esDeLaRegion("Sudamerica", unaLlamada))
            return 0.50 * unaLlamada.duracionEnMinutos();

        if(esDeLaRegion("Norteamerica", unaLlamada) || esDeLaRegion("Europa", unaLlamada))
            return 0.70 * unaLlamada.duracionEnMinutos();

        return 1.5 * unaLlamada.duracionEnMinutos();
    }

    protected boolean esDeLaRegion(String unaRegion, Llamada unaLlamada){
        return listadoDeCodigosDePaisPorRegion.get(unaRegion).contains(unaLlamada.destino().codigoDePais());
    }
}
