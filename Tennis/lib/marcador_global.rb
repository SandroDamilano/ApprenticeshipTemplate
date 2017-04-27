class MarcadorGlobal

  def initialize(un_jugador, otro_jugador)
    @servidor = MarcadorDeJugador.new(un_jugador)
    @jugador_1 = @servidor
    @restador = MarcadorDeJugador.new(otro_jugador)
    @jugador_2 = @restador
    @comunicador_de_resultado = ComunicadorDeResultado.new
  end

  def servidor
    @servidor.jugador
  end

  def restador
    @restador.jugador
  end

  def cambio_de_servicio
    nuevo_servidor = @restador
    @restador = @servidor
    @servidor = nuevo_servidor
  end

  def punto_para_servidor
    self.punto_para_contra(@servidor, @restador)
  end

  def punto_para_restador
    self.punto_para_contra(@restador, @servidor)
  end

  def punto_para_contra(un_marcador_de_jugador, otro_marcador_de_jugador)
    games_totales = @servidor.games + @restador.games
    un_marcador_de_jugador.ganar_punto_contra(otro_marcador_de_jugador)

    if (games_totales != @servidor.games + @restador.games)
      self.cambio_de_servicio
    end
  end

  def puntaje_servidor
    @servidor.puntaje_game
  end

  def puntaje_restador
    @restador.puntaje_game
  end

  def resultado_game
    @comunicador_de_resultado.resultado_game_de(self)
  end

  def resultado_set
    '' << @jugador_1.games.to_s << ' - ' << @jugador_2.games.to_s
  end

  def termino_el_set?
    @servidor.termino_el_set?
  end

  def ganador
    marcadores_de_jugador = [@servidor, @restador]
    marcador_de_jugador_ganador = marcadores_de_jugador.detect(lambda {MarcadorDeJugador.new('')}){|marcador_de_jugador| marcador_de_jugador.gano?}
    marcador_de_jugador_ganador.jugador
  end

end