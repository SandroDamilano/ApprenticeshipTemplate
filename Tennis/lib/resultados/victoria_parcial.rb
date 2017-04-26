class VictoriaParcial

  def descripcion_para(un_marcador)
    un_marcador.puntaje_servidor << ' - ' << un_marcador.puntaje_restador
  end

  def can_handle(puntaje_servidor, puntaje_restador)
    puntaje_servidor != puntaje_restador && puntaje_servidor != PuntajeA.new.descripcion && puntaje_restador != PuntajeA.new.descripcion
  end

end
