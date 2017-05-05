import main.Facturador;
import main.LineaTelefonica;
import main.Telefono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sandro on 05/05/17.
 */
public class LlamadasTestFactory {

    private LineaTelefonica lineaTelefonica;

    public LlamadasTestFactory(){
        lineaTelefonica = this.nuevaLineaTelefonica();
    }

    public Facturador nuevoFacturador(){
        List<String> codigosDeSudamerica = Arrays.asList("54", "22");
        List<String> codigosDeNorteamerica = Arrays.asList("1");
        List<String> codigosDeEuropa = Arrays.asList("12");
        List<String> codigosDelRestoDelMundo = Arrays.asList("80");
        Map<String, List<String>> listadoDeCodigosDePaisesPorRegion = new HashMap<>();
        listadoDeCodigosDePaisesPorRegion.put("Sudamerica", codigosDeSudamerica);
        listadoDeCodigosDePaisesPorRegion.put("Norteamerica", codigosDeNorteamerica);
        listadoDeCodigosDePaisesPorRegion.put("Europa", codigosDeEuropa);
        listadoDeCodigosDePaisesPorRegion.put("RestoDelMundo", codigosDelRestoDelMundo);

        return new Facturador(listadoDeCodigosDePaisesPorRegion);
    }

    public LineaTelefonica nuevaLineaTelefonica(){
        return new LineaTelefonica();
    }

    public LineaTelefonica lineaTelefonica(){
        return lineaTelefonica;
    }

    public Telefono telefonoBsAs(){
        return new Telefono("54", 011, 45671234);
    }

    public Telefono telefonoCordoba(){
        return new Telefono("54", 015, 3245673);
    }
}
