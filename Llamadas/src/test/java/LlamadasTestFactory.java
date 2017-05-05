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

    private CodigosFactory codiguera;
    private LineaTelefonica lineaTelefonica;

    public LlamadasTestFactory(){
        lineaTelefonica = this.nuevaLineaTelefonica();
        codiguera = new CodigosFactory();
    }

    public Facturador nuevoFacturador(){
        List<String> codigosDeSudamerica = Arrays.asList(codiguera.codigoArgentina(), codiguera.codigoUruguay());
        List<String> codigosDeNorteamerica = Arrays.asList(codiguera.codigoUSA());
        List<String> codigosDeEuropa = Arrays.asList(codiguera.codigoEspania());
        List<String> codigosDelRestoDelMundo = Arrays.asList(codiguera.codigoAustralia());
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
        return new Telefono(codiguera.codigoArgentina(), codiguera.codigoBsAs(), 45671234);
    }

    public Telefono telefonoCordoba(){
        return new Telefono(codiguera.codigoArgentina(), codiguera.codigoCordoba(), 3245673);
    }
}
