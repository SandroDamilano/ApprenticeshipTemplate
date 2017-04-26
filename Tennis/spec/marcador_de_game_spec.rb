require 'rspec'
require 'require_all'
require_all 'lib'

describe MarcadorDeGame do

  let(:marcador) {MarcadorDeGame.new(MarcadorDeSet.new)}
  let(:rival) do MarcadorDeGame.new(MarcadorDeSet.new) end

  it 'cuando el marcador se inicializa está en 0' do
    expect(marcador.puntos).to eq 0
  end

  it 'cuando se anota un punto en un marcador en 0 pasa a estar en 15' do
    marcador.ganar_punto_contra(rival)
    expect(marcador.puntos).to eq 15
  end

  it 'cuando un marcador está en 15 y se anota un punto, pasa a estar en 30' do
    score_many_against(marcador, 1, rival)
    marcador.ganar_punto_contra(rival)
    expect(marcador.puntos).to eq 30
  end

  it 'cuando un marcador está en 30 y se anota un punto, pasa a estar en 40' do
    score_many_against(marcador, 2, rival)
    marcador.ganar_punto_contra(rival)
    expect(marcador.puntos).to eq 40
  end

  it 'cuando un marcador está en 40 y se anota un punto, pasa a estar en 0 de nuevo' do
    score_many_against(marcador, 3, rival)
    marcador.ganar_punto_contra(rival)
    expect(marcador.puntos).to eq 0
  end

  it 'cuando un marcador está en 40 contra otro que está en 40 y anota, pasa a estar en ventaja' do
    score_many_against(marcador, 3, rival)
    score_many_against(rival, 3, marcador)
    marcador.ganar_punto_contra(rival)
    expect(marcador.puntos).to eq 'A'
  end

  it 'cuando un marcador está en Ventaja y anota, pasa a estar en 0' do
    score_many_against(rival, 3, marcador)
    score_many_against(marcador, 4, rival)
    marcador.ganar_punto_contra(rival)
    expect(marcador.puntos).to eq 0
  end

  it 'cuando un marcador está en 40 contra otro que está en ventaja y anota, el rival pasa a estar en 0' do
    score_many_against(marcador, 3, rival)
    score_many_against(rival, 4, marcador)
    marcador.ganar_punto_contra(rival)
    expect(rival.puntos).to eq 40
  end

  it 'cuando un marcador anota y pasa a 0, el marcador rival tambien pasa a estar en 0' do
    score_many_against(rival, 2, marcador)
    score_many_against(marcador, 4, rival)
    expect(marcador.puntos).to eq 0
    expect(rival.puntos).to eq 0
  end

  def score_many_against(un_marcador, points, a_rival)
    points.times do
      un_marcador.ganar_punto_contra(a_rival)
    end
  end

end