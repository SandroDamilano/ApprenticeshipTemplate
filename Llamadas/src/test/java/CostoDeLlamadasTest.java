import main.Facturador;
import main.Llamada;
import main.Telefono;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by sandro on 02/05/17.
 */
public class CostoDeLlamadasTest {

    protected Facturador facturador;

    @Before
    public void setUp(){
        List<String> codigosDeSudamerica = Arrays.asList("54", "22");
        List<String> codigosDeNorteamerica = Arrays.asList("1");
        List<String> codigosDeEuropa = Arrays.asList("12");
        List<String> codigosDelRestoDelMundo = Arrays.asList("80");
        Map<String, List<String>> listadoDeCodigosDePaisesPorRegion = new HashMap<>();
        listadoDeCodigosDePaisesPorRegion.put("Sudamerica", codigosDeSudamerica);
        listadoDeCodigosDePaisesPorRegion.put("Norteamerica", codigosDeNorteamerica);
        listadoDeCodigosDePaisesPorRegion.put("Europa", codigosDeEuropa);
        listadoDeCodigosDePaisesPorRegion.put("RestoDelMundo", codigosDelRestoDelMundo);

        facturador = new Facturador(listadoDeCodigosDePaisesPorRegion);
    }

    @Test
    public void unaLlamadaNacionalCuesta30CentavosPorMinuto() {
        Telefono telefonoBsAs = new Telefono("+54", 011, 45671234);
        Telefono telefonoCordoba = new Telefono("+54", 015, 3245673);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(20));
        Llamada llamadaNacional = new Llamada(telefonoBsAs, telefonoCordoba, intervaloDeLlamada);
        Assert.assertEquals(6.00, facturador.montoDe(llamadaNacional), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalASudamericaCuesta50CentavosElMinuto() {
        Telefono telefonoBsAs = new Telefono("54", 011, 45671234);
        Telefono telefonoUruguay = new Telefono("22", 111, 671234);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(16));
        Llamada llamadaInternacional = new Llamada(telefonoBsAs, telefonoUruguay, intervaloDeLlamada);
        Assert.assertEquals(8.00, facturador.montoDe(llamadaInternacional), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalANorteAmericaCuesta70CentavosElMinuto() {
        Telefono telefonoBsAs = new Telefono("54", 011, 45671234);
        Telefono telefonoUSA = new Telefono("1", 1, 65671234);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(30));
        Llamada llamadaInternacional = new Llamada(telefonoBsAs, telefonoUSA, intervaloDeLlamada);
        Assert.assertEquals(21.00, facturador.montoDe(llamadaInternacional), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalAEuropaCuesta70CentavosElMinuto() {
        Telefono telefonoBsAs = new Telefono("54", 011, 45671234);
        Telefono telefonoEspania = new Telefono("12", 13, 35651234);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(20));
        Llamada llamadaInternacional = new Llamada(telefonoBsAs, telefonoEspania, intervaloDeLlamada);
        Assert.assertEquals(14.00, facturador.montoDe(llamadaInternacional), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalAlRestoDelMundoCuesta1Peso50CentavosElMinuto() {
        Telefono telefonoBsAs = new Telefono("54", 011, 45671234);
        Telefono telefonoAustralia = new Telefono("80", 95, 5651234);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(15));
        Llamada llamadaInternacional = new Llamada(telefonoBsAs, telefonoAustralia, intervaloDeLlamada);
        Assert.assertEquals(22.50, facturador.montoDe(llamadaInternacional), 0.01);
    }

    @Test
    public void unaLlamadaLocalEnFinDeSemanaCuesta10CentavosElMinuto() {
        Telefono telefonoBsAs = new Telefono("54", 011, 45671234);
        Telefono otroTelefonoBsAs = new Telefono("54", 011, 45671235);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 29, 17, 00), Duration.standardMinutes(25));
        Llamada llamadaLocal = new Llamada(telefonoBsAs, otroTelefonoBsAs, intervaloDeLlamada);
        Assert.assertEquals(2.50, facturador.montoDe(llamadaLocal), 0.01);
    }

    @Test
    public void unaLlamadaLocalEnDiaHabilFueraDeHoraPicoCuesta10CentavosElMinuto() {
        Telefono telefonoBsAs = new Telefono("54", 011, 45671234);
        Telefono otroTelefonoBsAs = new Telefono("54", 011, 45671235);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 20, 00), Duration.standardMinutes(20));
        Llamada llamadaLocal = new Llamada(telefonoBsAs, otroTelefonoBsAs, intervaloDeLlamada);
        Assert.assertEquals(2.00, facturador.montoDe(llamadaLocal), 0.01);
    }

    @Test
    public void unaLlamadaLocalEnDiaHabilYHoraPicoCuesta20CentavosElMinuto() {
        Telefono telefonoBsAs = new Telefono("54", 011, 45671234);
        Telefono otroTelefonoBsAs = new Telefono("54", 011, 45671235);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(47));
        Llamada llamadaLocal = new Llamada(telefonoBsAs, otroTelefonoBsAs, intervaloDeLlamada);
        Assert.assertEquals(9.40, facturador.montoDe(llamadaLocal), 0.01);
    }

}
