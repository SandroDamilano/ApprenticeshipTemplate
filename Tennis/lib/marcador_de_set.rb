class MarcadorDeSet

  attr_reader :games

  def initialize
    @games = 0
    @estado = EstadoSetEnJuego.new
    @es_ganador = false
  end

  def ganar_game_contra(otro_marcador_de_set)
    @estado.ganar_game_contra(self, otro_marcador_de_set)
  end

  def sumar_game
    @games += 1
  end

  def finalizar
    @estado = EstadoSetFinalizado.new
  end

  def finalizado?
    @estado.finalizado?
  end

  def gano
    self.finalizar
    @es_ganador = true
  end

  def perdio
    self.finalizar
  end

  def gano_el_jugador_representado?
    @es_ganador
  end

end