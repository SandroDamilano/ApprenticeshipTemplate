class Puntaje40
  def puntaje
    40
  end

  def puntaje_proximo_si_el_otro_es(puntaje_rival)
    puntaje_rival.puntaje_proximo_del_rival_si_es_40
  end

  def puntaje_proximo_del_rival_si_es_40
    PuntajeA.new
  end

  def puntaje_del_rival_si_anotas(puntaje_rival)
    puntaje_rival.puntaje_si_marco_el_40
  end

  def puntaje_si_marco_el_40
    Puntaje40.new
  end

  def puntaje_si_marco_el_a
    Puntaje0.new
  end

end