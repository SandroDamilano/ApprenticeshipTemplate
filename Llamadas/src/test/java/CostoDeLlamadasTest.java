import main.Llamada;
import main.Telefono;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sandro on 02/05/17.
 */
public class CostoDeLlamadasTest {

    private LlamadasTestFactory factory;
    private CodigosFactory codiguera;

    @Before
    public void setUp(){
        factory = new LlamadasTestFactory();
        codiguera = new CodigosFactory();
    }

    @Test
    public void unaLlamadaNacionalCuesta30CentavosPorMinuto() {
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(20));
        Llamada llamadaNacional = new Llamada(factory.telefonoBsAs(), factory.telefonoCordoba(), intervaloDeLlamada);
        Assert.assertEquals(6.00, factory.nuevoFacturador().montoDe(llamadaNacional), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalASudamericaCuesta50CentavosElMinuto() {
        Telefono telefonoUruguay = new Telefono(codiguera.codigoUruguay(), 111, 671234);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(16));
        Llamada llamadaInternacional = new Llamada(factory.telefonoBsAs(), telefonoUruguay, intervaloDeLlamada);
        Assert.assertEquals(8.00, factory.nuevoFacturador().montoDe(llamadaInternacional), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalANorteAmericaCuesta70CentavosElMinuto() {
        Telefono telefonoUSA = new Telefono(codiguera.codigoUSA(), 1, 65671234);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(30));
        Llamada llamadaInternacional = new Llamada(factory.telefonoBsAs(), telefonoUSA, intervaloDeLlamada);
        Assert.assertEquals(21.00, factory.nuevoFacturador().montoDe(llamadaInternacional), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalAEuropaCuesta70CentavosElMinuto() {
        Telefono telefonoEspania = new Telefono(codiguera.codigoEspania(), 13, 35651234);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(20));
        Llamada llamadaInternacional = new Llamada(factory.telefonoBsAs(), telefonoEspania, intervaloDeLlamada);
        Assert.assertEquals(14.00, factory.nuevoFacturador().montoDe(llamadaInternacional), 0.01);
    }

    @Test
    public void unaLlamadaInternacionalAlRestoDelMundoCuesta1Peso50CentavosElMinuto() {
        Telefono telefonoAustralia = new Telefono(codiguera.codigoAustralia(), 95, 5651234);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(15));
        Llamada llamadaInternacional = new Llamada(factory.telefonoBsAs(), telefonoAustralia, intervaloDeLlamada);
        Assert.assertEquals(22.50, factory.nuevoFacturador().montoDe(llamadaInternacional), 0.01);
    }

    @Test
    public void unaLlamadaLocalEnFinDeSemanaCuesta10CentavosElMinuto() {
        Telefono otroTelefonoBsAs = new Telefono(codiguera.codigoArgentina(), codiguera.codigoBsAs(), 45671235);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 29, 17, 00), Duration.standardMinutes(25));
        Llamada llamadaLocal = new Llamada(factory.telefonoBsAs(), otroTelefonoBsAs, intervaloDeLlamada);
        Assert.assertEquals(2.50, factory.nuevoFacturador().montoDe(llamadaLocal), 0.01);
    }

    @Test
    public void unaLlamadaLocalEnDiaHabilFueraDeHoraPicoCuesta10CentavosElMinuto() {
        Telefono otroTelefonoBsAs = new Telefono(codiguera.codigoArgentina(), codiguera.codigoBsAs(), 45671235);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 20, 00), Duration.standardMinutes(20));
        Llamada llamadaLocal = new Llamada(factory.telefonoBsAs(), otroTelefonoBsAs, intervaloDeLlamada);
        Assert.assertEquals(2.00, factory.nuevoFacturador().montoDe(llamadaLocal), 0.01);
    }

    @Test
    public void unaLlamadaLocalEnDiaHabilYHoraPicoCuesta20CentavosElMinuto() {
        Telefono otroTelefonoBsAs = new Telefono(codiguera.codigoArgentina(), codiguera.codigoBsAs(), 45671235);
        Interval intervaloDeLlamada = new Interval(new DateTime(2017, 4, 26, 18, 20), Duration.standardMinutes(47));
        Llamada llamadaLocal = new Llamada(factory.telefonoBsAs(), otroTelefonoBsAs, intervaloDeLlamada);
        Assert.assertEquals(9.40, factory.nuevoFacturador().montoDe(llamadaLocal), 0.01);
    }

}
