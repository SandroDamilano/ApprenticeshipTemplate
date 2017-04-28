package main;

import armadoresDeJugadas.*;
import jugadas.TipoDeJugada;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sandro on 10/04/17.
 */
public class ProveedorDeJugadas {

    public TipoDeJugada tipoDe(PokerHand unaMano) {
        List<ArmadorDeJugadas> armadoresDeTiposDeManos = Arrays.asList(new ArmadorDeJugadaPar(), new ArmadorDeJugadaParDoble(), new ArmadorDeJugadaPierna());

        ArmadorDeJugadas armador = armadoresDeTiposDeManos.stream()
                                        .filter(valor -> valor.canHandle(unaMano))
                                        .findFirst()
                                        .orElse(new ArmadorDeJugadaNaipeMasAlto());

        return armador.armarJugada(unaMano.naipes());
    }
}
