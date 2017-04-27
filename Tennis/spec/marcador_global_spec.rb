require 'rspec'
require 'require_all'
require_all 'lib'

describe MarcadorGlobal do

  let(:marcador) {MarcadorGlobal.new('Del Potro', 'Nalbandian')}

  describe 'Servicio' do

    it 'El marcador debe responder quién es el servidor' do
      expect(marcador.servidor).to eq('Del Potro')
    end

    it 'El marcador debe responder quién es el restador' do
      expect(marcador.restador).to eq('Nalbandian')
    end

    it 'Cuando ocurre un cambio de servicio, el servidor pasa a ser el restador y viceversa' do
      servidor = marcador.servidor
      restador = marcador.restador
      marcador.cambio_de_servicio
      expect(marcador.servidor).to eq(restador)
      expect(marcador.restador).to eq(servidor)
    end

    it 'Cuando un jugador gana un game, debe ocurrir un cambio de servicio' do
      marcador.punto_para_servidor
      marcador.punto_para_servidor
      marcador.punto_para_servidor
      servidor = marcador.servidor
      restador = marcador.restador
      marcador.punto_para_servidor
      expect(marcador.servidor).to eq(restador)
      expect(marcador.restador).to eq(servidor)
    end

  end

  describe 'Puntuación de game' do

    it 'Cuando el marcador global se inicializa, el game va Love all' do
      expect(marcador.resultado_game).to eq('Love all')
    end

    it 'Cuando el servidor gana un punto, el game va Fifteen - Love' do
      marcador.punto_para_servidor
      expect(marcador.resultado_game).to eq('Fifteen - Love')
    end

    it 'Cuando el restador gana un punto, el game va Love - Fifteen' do
      marcador.punto_para_restador
      expect(marcador.resultado_game).to eq('Love - Fifteen')
    end

    it 'Cuando el partido va empatado, el resultado es el puntaje más la palabra all' do
      marcador.punto_para_servidor
      marcador.punto_para_restador
      expect(marcador.resultado_game).to eq('Fifteen all')
    end

    it 'Cuando el partido va empatado en 40, el resultado es Deuce' do
      ganar_puntos_para_servidor(marcador, 3)
      ganar_puntos_para_restador(marcador, 3)
      expect(marcador.resultado_game).to eq('Deuce')
    end

    it 'Cuando el un jugador tiene ventaja, el resultado es Advantage más el nombre del jugador' do
      ganar_puntos_para_servidor(marcador, 3)
      ganar_puntos_para_restador(marcador, 3)
      marcador.punto_para_servidor
      expect(marcador.resultado_game).to eq('Advantage Del Potro')
    end

  end

  describe 'Puntuación de set' do

    it 'Cuando el marcador global se inicializa, el set va 0 - 0' do
      expect(marcador.resultado_set).to eq('0 - 0')
    end

    it 'Cuando el jugador 1 gana un game, el set va 1 - 0' do
      ganar_puntos_para_servidor(marcador, 4)
      expect(marcador.resultado_set).to eq('1 - 0')
    end

  end

  describe 'Finalización del set' do

    it 'Cuando ningún jugador ganó el set, el set está en juego' do
      expect(marcador.termino_el_set?).to be_falsey
    end

    it 'Cuando el set finalizó, el marcador sabe responder quién lo ganó' do
      ganar_puntos_para_servidor(marcador, 4)
      ganar_puntos_para_restador(marcador, 4)
      ganar_puntos_para_servidor(marcador, 4)
      ganar_puntos_para_restador(marcador, 4)
      ganar_puntos_para_servidor(marcador, 4)
      ganar_puntos_para_restador(marcador, 4)
      expect(marcador.ganador).to eq 'Del Potro'
    end

    it 'Cuando el set no finalizó aún, no hay ganador' do
      expect(marcador.ganador).to eq ''
    end

  end

  def ganar_puntos_para_servidor(un_marcador, una_cantidad)
    ganar_puntos(un_marcador, una_cantidad){|un_marcador_global| un_marcador_global.punto_para_servidor}
  end

  def ganar_puntos_para_restador(un_marcador, una_cantidad)
    ganar_puntos(un_marcador, una_cantidad){|un_marcador_global| un_marcador_global.punto_para_restador}
  end

  def ganar_puntos(un_marcador, una_cantidad, &sumador_de_puntos)
    una_cantidad.times do
      sumador_de_puntos.call(un_marcador)
    end
  end

end