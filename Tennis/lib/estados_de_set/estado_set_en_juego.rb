class EstadoSetEnJuego

  def ganar_game_contra(un_marcador_de_set, otro_marcador_de_set)
    if (un_marcador_de_set.games > otro_marcador_de_set.games && un_marcador_de_set.games >= 5)
      un_marcador_de_set.gano
      otro_marcador_de_set.perdio
    end

    un_marcador_de_set.sumar_game
  end

  def finalizado?
    false
  end

end