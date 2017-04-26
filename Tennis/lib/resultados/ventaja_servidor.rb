class VentajaServidor

  def descripcion_para(un_marcador)
    'Advantage ' << un_marcador.servidor
  end

  def can_handle(puntaje_servidor, puntaje_restador)
    puntaje_servidor == PuntajeA.new.descripcion
  end

end
