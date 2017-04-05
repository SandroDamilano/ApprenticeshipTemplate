public class Moneda {

    protected int denominacion;

    public Moneda(int unaDenominacion){
        denominacion = unaDenominacion;
    }

    public Moneda sumar(Moneda otraMoneda){
        return new Moneda(this.denominacion + otraMoneda.denominacion);
    }

    public boolean esMayorA(Moneda otraMoneda){
        return this.denominacion() > otraMoneda.denominacion();
    }

    public int denominacion(){
        return denominacion;
    }
}
