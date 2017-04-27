class MarcadorDeSet

  attr_reader :games, :marcador_de_game

  def initialize
    @games = 0
    @estado = EstadoSetEnJuego.new
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

end