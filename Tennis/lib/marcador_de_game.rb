class MarcadorDeGame

  attr_reader :puntaje

  def initialize
    @puntaje = Puntaje0.new
  end

  def puntos
    @puntaje.puntaje
  end

  def anotaste_contra(un_marcador_rival)
    un_marcador_rival.sufriste_anotacion_de(self)
    @puntaje = @puntaje.puntaje_proximo_si_el_otro_es(un_marcador_rival.puntaje)
  end

  def sufriste_anotacion_de(un_marcador_rival)
    @puntaje = un_marcador_rival.puntaje.puntaje_del_rival_si_anotas(self.puntaje)
  end

end