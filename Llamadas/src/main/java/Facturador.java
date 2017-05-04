import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by sandro on 04/05/17.
 */
public class Facturador {

    protected List<FacturadorDeLlamada> facturadoresDeLlamadas;

    public Facturador(Map<String, List<String>> unListadoDeCodigosDePaisesPorRegion){
        facturadoresDeLlamadas = Arrays.asList(new FacturadorDeLlamadaNacional(), new FacturadorDeLlamadaInternacional(unListadoDeCodigosDePaisesPorRegion));
    }

    public Double montoDe(Llamada unaLlamada) {
        FacturadorDeLlamada facturadorDeLlamadaPropuesto = facturadoresDeLlamadas.stream()
                                                            .filter(facturadorDeLlamada -> facturadorDeLlamada.esAplicablePara(unaLlamada))
                                                            .findFirst()
                                                            .get();
        return facturadorDeLlamadaPropuesto.costoDe(unaLlamada);
    }

}
