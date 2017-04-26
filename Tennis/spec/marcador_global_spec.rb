require 'rspec'
require 'require_all'
require_all 'lib'

describe MarcadorGlobal do

  let(:marcador_rival) {MarcadorGlobal.new}

  it 'Cuando se inicia un marcador global, no tiene puntos ni games' do
    expect(subject.puntos).to eq(0)
    expect(subject.games).to eq(0)
  end

  it 'Cuando un marcador gana un punto, su puntaje es 15' do
    subject.ganar_punto_contra(marcador_rival)
    expect(subject.puntos).to eq 15
  end

  it 'Cuando un marcador gana un punto, y con él gana el game, pasa a tener 1 game' do
    subject.ganar_punto_contra(marcador_rival)
    subject.ganar_punto_contra(marcador_rival)
    subject.ganar_punto_contra(marcador_rival)
    subject.ganar_punto_contra(marcador_rival)
    expect(subject.games).to eq 1
  end

end