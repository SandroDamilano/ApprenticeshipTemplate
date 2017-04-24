class PuntajeA
  def puntaje
    'A'
  end

  def puntaje_proximo_si_el_otro_es(puntaje_rival)
    Puntaje0.new
  end

  def puntaje_proximo_del_rival_si_es_40
    Puntaje40.new
  end

  def puntaje_del_rival_si_anotas(puntaje_rival)
    puntaje_rival.puntaje_si_marco_el_a
  end

  def puntaje_si_marco_el_40
    Puntaje40.new
  end

  def puntaje_si_marco_el_a
    raise 'El rival no puede estar en ventaja'
  end

end