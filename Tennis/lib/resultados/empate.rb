class Empate

  def descripcion_para(un_marcador)
    un_marcador.puntaje_servidor << ' all'
  end

  def can_handle(puntaje_servidor, puntaje_restador)
    puntaje_servidor == puntaje_restador && puntaje_servidor != Puntaje40.new.descripcion
  end

end
