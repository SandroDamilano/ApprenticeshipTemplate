class EstadoSetFinalizado

  def ganar_game_contra(un_marcador_de_set, otro_marcador_de_set)
    raise 'El set finalizó'
  end

  def finalizado?
    true
  end

end