class ComunicadorDeResultado

  def initialize
    @resultados_posibles = [Deuce.new, Empate.new, VentajaServidor.new, VentajaRestador.new, VictoriaParcial.new]
  end

  def resultado_game_de(un_marcador_global)
    resultado = @resultados_posibles.detect{|un_resultado| un_resultado.can_handle(un_marcador_global.puntaje_servidor, un_marcador_global.puntaje_restador)}
    resultado.descripcion_para(un_marcador_global)
  end

end