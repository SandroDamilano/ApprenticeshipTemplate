class Puntaje01530

  def self.puntaje_0
    self.new(0, self.puntaje_15, 'Love')
  end

  def self.puntaje_15
    self.new(15, self.puntaje_30, 'Fifteen')
  end

  def self.puntaje_30
    self.new(30, Puntaje40.new, 'Thirty')
  end

  attr_reader :puntaje, :descripcion

  def initialize(un_puntaje, un_puntaje_proximo, una_descripcion)
    @puntaje = un_puntaje
    @puntaje_proximo = un_puntaje_proximo
    @descripcion = una_descripcion
  end

  def gano_el_punto_contra(marcador_ganador, marcador_rival)
    marcador_ganador.actualizar_puntaje(@puntaje_proximo)
  end

  def perdio_el_punto_contra_40(marcador_perdedor, marcador_rival)
    marcador_rival.ganar_game_contra(marcador_perdedor)
  end
end