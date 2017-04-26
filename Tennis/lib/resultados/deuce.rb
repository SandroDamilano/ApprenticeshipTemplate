class Deuce

  def descripcion_para(un_marcador)
    'Deuce'
  end

  def can_handle(puntaje_servidor, puntaje_restador)
    puntaje_servidor == puntaje_restador && puntaje_servidor == Puntaje40.new.descripcion
  end

end
