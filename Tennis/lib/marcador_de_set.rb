class MarcadorDeSet

  attr_reader :games, :marcador_de_game

  def initialize #(un_marcador_de_game)
    @games = 0
    # @marcador_de_game = un_marcador_de_game
  end

  def ganar_game_contra(otro_marcador_de_set)
    if (@games > otro_marcador_de_set.games && @games >= 5)
      @games = 0
    else
      @games += 1
    end
  end

  def ganar_punto_contra(otro_marcador_de_set)
    # @marcador_de_game.anotaste_contra(otro_marcador_de_set.marcador_de_game)
  end

end