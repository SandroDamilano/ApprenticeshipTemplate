package main;

import armadoresDeJugadas.ArmadorDeJugadaNaipeMasAlto;
import armadoresDeJugadas.ArmadorDeJugadaPar;
import armadoresDeJugadas.ArmadorDeJugadaParDoble;
import armadoresDeJugadas.ArmadorDeJugadas;
import jugadas.TipoDeJugada;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sandro on 10/04/17.
 */
public class ProveedorDeJugadas {

    public TipoDeJugada tipoDe(PokerHand unaMano) {
//        List<TipoDeJugada> tiposDeManos = Arrays.asList(new JugadaPar(unaMano.naipes), new JugadaParDoble(unaMano.naipes));
        List<ArmadorDeJugadas> armadoresDeTiposDeManos = Arrays.asList(new ArmadorDeJugadaPar(), new ArmadorDeJugadaParDoble());

        ArmadorDeJugadas armador = armadoresDeTiposDeManos.stream()
                                        .filter(valor -> valor.canHandle(unaMano))
                                        .findFirst()
                                        .orElse(new ArmadorDeJugadaNaipeMasAlto());

        return armador.armarJugada(unaMano.naipes());
    }
}
