class EstadoSetEnJuego

  def ganar_game_contra(un_marcador_de_set, otro_marcador_de_set)
    if (un_marcador_de_set.games <= otro_marcador_de_set.games || un_marcador_de_set.games < 5)
      un_marcador_de_set.sumar_game
    else
      un_marcador_de_set.finalizar
      otro_marcador_de_set.finalizar
    end
  end

  def finalizado?
    false
  end

end