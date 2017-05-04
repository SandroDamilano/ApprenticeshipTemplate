package main;

/**
 * Created by sandro on 04/05/17.
 */
public class Telefono {

    protected String codigoDePais;
    protected Integer codigoDeArea;
    protected Integer numeroDeTelefono;

    public Telefono(String unCodigodePais, Integer unCodigoDeArea, Integer unNumeroDeTelefono) {
        codigoDePais = unCodigodePais;
        codigoDeArea = unCodigoDeArea;
        numeroDeTelefono = unNumeroDeTelefono;
    }

    public Integer codigoDeArea(){
        return codigoDeArea;
    }

    public String codigoDePais(){
        return codigoDePais;
    }

    public boolean esDelMismoPaisQue(Telefono otroTelefono) {
        return this.codigoDePais().equals(otroTelefono.codigoDePais());
    }

    public boolean esDelMismoAreaQue(Telefono otroTelefono) {
        return this.codigoDeArea().equals(otroTelefono.codigoDeArea());
    }
}
