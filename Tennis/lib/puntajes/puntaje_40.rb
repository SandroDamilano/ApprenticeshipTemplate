class Puntaje40
  def puntaje
    40
  end

  def gano_el_punto_contra(marcador_ganador, marcador_rival)
    marcador_rival.perder_punto_contra_40(marcador_ganador)
  end

  def perdio_el_punto_contra_40(marcador_perdedor, marcador_rival)
    marcador_rival.actualizar_puntaje(PuntajeA.new)
  end

end