package main;

import jugadas.JugadaCartaMasAlta;
import jugadas.JugadaPar;
import jugadas.TipoDeJugada;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sandro on 10/04/17.
 */
public class ProveedorDeJugadas {

    public TipoDeJugada tipoDe(PokerHand unaMano) {
        List<TipoDeJugada> tiposDeManos = Arrays.asList(new JugadaPar(unaMano));

        return tiposDeManos.stream()
                .filter(valor -> valor.canHandle(unaMano))
                .findFirst()
                .orElse(new JugadaCartaMasAlta(unaMano.cartas()));
    }
}
