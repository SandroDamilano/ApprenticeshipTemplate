package main;

import org.joda.time.YearMonth;

import java.util.List;

/**
 * Created by sandro on 02/05/17.
 */
public class FacturaTelefonica {

    LineaTelefonica lineaTelefonica;
    YearMonth mesDeAnio;

    public FacturaTelefonica(YearMonth unMesDeAnio, LineaTelefonica unaLineaTelefonica){
        mesDeAnio = unMesDeAnio;
        lineaTelefonica = unaLineaTelefonica;
    }

    public Double montoCon(Facturador unFacturador) {
        List<Llamada> llamadasDelMes = lineaTelefonica.llamadasDelMes(mesDeAnio);
        Double costoDeLlamadas = llamadasDelMes.stream().mapToDouble(llamada -> unFacturador.montoDe(llamada)).sum();
        return 10 + costoDeLlamadas;
    }
}
