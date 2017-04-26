class MarcadorDeSet

  attr_reader :games, :marcador_de_game

  def initialize
    @games = 0
  end

  def ganar_game_contra(otro_marcador_de_set)
    if (@games > otro_marcador_de_set.games && @games >= 5)
      @games = 0
    else
      @games += 1
    end
  end

end