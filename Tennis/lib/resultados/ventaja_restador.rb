class VentajaRestador

  def descripcion_para(un_marcador)
    'Advantage ' << un_marcador.restador
  end

  def can_handle(puntaje_servidor, puntaje_restador)
    puntaje_restador == PuntajeA.new.descripcion
  end

end
