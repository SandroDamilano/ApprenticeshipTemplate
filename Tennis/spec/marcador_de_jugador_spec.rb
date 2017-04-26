require 'rspec'
require 'require_all'
require_all 'lib'

describe MarcadorDeJugador do

  let(:marcador) {MarcadorDeJugador.new('Del Potro')}
  let(:marcador_rival) {MarcadorDeJugador.new('Nalbandian')}

  it 'Cuando se inicia un marcador global, no tiene puntos ni games' do
    expect(marcador.puntos).to eq(0)
    expect(marcador.games).to eq(0)
  end

  it 'Cuando un marcador gana un punto, su puntaje es 15' do
    marcador.ganar_punto_contra(marcador_rival)
    expect(marcador.puntos).to eq 15
  end

  it 'Cuando un marcador gana un punto, y con él gana el game, pasa a tener 1 game' do
    marcador.ganar_punto_contra(marcador_rival)
    marcador.ganar_punto_contra(marcador_rival)
    marcador.ganar_punto_contra(marcador_rival)
    marcador.ganar_punto_contra(marcador_rival)
    expect(marcador.games).to eq 1
  end

end