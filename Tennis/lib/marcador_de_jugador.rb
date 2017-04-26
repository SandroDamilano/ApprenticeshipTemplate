class MarcadorDeJugador

  attr_reader :marcador_de_game, :marcador_de_set

  def initialize
    @marcador_de_set = MarcadorDeSet.new
    @marcador_de_game = MarcadorDeGame.new(@marcador_de_set)
  end

  def puntos
    @marcador_de_game.puntos
  end

  def games
    @marcador_de_set.games
  end

  def ganar_punto_contra(otro_marcador_global)
    @marcador_de_game.ganar_punto_contra(otro_marcador_global.marcador_de_game)
  end

end