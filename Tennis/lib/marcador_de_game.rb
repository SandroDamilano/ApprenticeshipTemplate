class MarcadorDeGame

  attr_reader :puntaje, :marcador_de_set

  def initialize(un_marcador_de_set)
    @puntaje = Puntaje01530.puntaje_0
    @marcador_de_set = un_marcador_de_set
  end

  def puntos
    @puntaje.puntaje
  end

  def descripcion_puntos
    @puntaje.descripcion
  end

  def ganar_punto_contra(un_marcador_rival)
    @puntaje.gano_el_punto_contra(self,un_marcador_rival)
  end

  def perder_punto_contra_40(un_marcador_rival)
    @puntaje.perdio_el_punto_contra_40(self, un_marcador_rival)
  end

  def actualizar_puntaje(un_puntaje)
    @puntaje = un_puntaje
  end

  def ganar_game_contra(un_marcador_rival)
    @marcador_de_set.ganar_game_contra(un_marcador_rival.marcador_de_set)
    self.actualizar_puntaje(Puntaje01530.puntaje_0)
    un_marcador_rival.actualizar_puntaje(Puntaje01530.puntaje_0)
  end

end