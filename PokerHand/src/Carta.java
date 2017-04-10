import valoresdeCartas.ValorDeCarta;
import valoresdeCartas.ValorNumerico;

public class Carta {

    protected ValorDeCarta valor;
    protected Character palo;

    public Carta(Integer unValor, Character unPalo){
        valor = new ValorNumerico(unValor);
        palo = unPalo;
    }

    public Carta(String unValor, Character unPalo){
//        switch (unValor){
//            case "A": valor = 14;
//                break;
//            case "K": valor = 13;
//                break;
//            case "Q": valor = 12;
//                break;
//            case "J": valor = 11;
//                break;
//            default:
//                try {
//                    throw new Exception("No existe esa carta");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//        }
        valor = new ProveedorDeValoresDeCartas().obtenerValorPara(unValor);
        palo = unPalo;
    }

    public boolean esMayorQue(Carta otraCarta){
        return valor.esMayorQue(otraCarta.valor);
    }

//    public Integer valor(){
//        return valor;
//    }
}
