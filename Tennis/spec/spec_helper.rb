class SpecHelper

  def sumar_games(marcador_de_set, veces, otro_marcador_de_set)
    veces.times do
      marcador_de_set.ganar_game_contra(otro_marcador_de_set)
    end
  end

  def score_many_against(un_marcador, points, a_rival)
    points.times do
      un_marcador.ganar_punto_contra(a_rival)
    end
  end

end