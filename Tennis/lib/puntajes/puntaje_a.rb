class PuntajeA
  def puntaje
    'A'
  end

  def gano_el_punto_contra(marcador_ganador, marcador_rival)
    marcador_ganador.ganar_game_contra(marcador_rival)
  end

  def perdio_el_punto_contra_40(marcador_perdedor, marcador_rival)
    marcador_perdedor.actualizar_puntaje(Puntaje40.new)
  end

end