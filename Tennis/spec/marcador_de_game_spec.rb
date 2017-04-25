require 'rspec'
require 'require_all'
require_all 'lib'

describe MarcadorDeGame do

  let(:rival) do
    MarcadorDeGame.new
  end
  let(:helper) { SpecHelper.new }

  it 'cuando el marcador se inicializa está en 0' do
    expect(subject.puntos).to eq 0
  end

  it 'cuando se anota un punto en un marcador en 0 pasa a estar en 15' do
    subject.ganar_punto_contra(rival)
    expect(subject.puntos).to eq 15
  end

  it 'cuando un marcador está en 15 y se anota un punto, pasa a estar en 30' do
    helper.score_many_against(subject, 1, rival)
    subject.ganar_punto_contra(rival)
    expect(subject.puntos).to eq 30
  end

  it 'cuando un marcador está en 30 y se anota un punto, pasa a estar en 40' do
    helper.score_many_against(subject, 2, rival)
    subject.ganar_punto_contra(rival)
    expect(subject.puntos).to eq 40
  end

  it 'cuando un marcador está en 40 y se anota un punto, pasa a estar en 0 de nuevo' do
    helper.score_many_against(subject, 3, rival)
    subject.ganar_punto_contra(rival)
    expect(subject.puntos).to eq 0
  end

  it 'cuando un marcador está en 40 contra otro que está en 40 y anota, pasa a estar en ventaja' do
    helper.score_many_against(subject, 3, rival)
    helper.score_many_against(rival, 3, subject)
    subject.ganar_punto_contra(rival)
    expect(subject.puntos).to eq 'A'
  end

  it 'cuando un marcador está en Ventaja y anota, pasa a estar en 0' do
    helper.score_many_against(rival, 3, subject)
    helper.score_many_against(subject, 4, rival)
    subject.ganar_punto_contra(rival)
    expect(subject.puntos).to eq 0
  end

  it 'cuando un marcador está en 40 contra otro que está en ventaja y anota, el rival pasa a estar en 0' do
    helper.score_many_against(subject, 3, rival)
    helper.score_many_against(rival, 4, subject)
    subject.ganar_punto_contra(rival)
    expect(rival.puntos).to eq 40
  end

  it 'cuando un marcador anota y pasa a 0, el marcador rival tambien pasa a estar en 0' do
    helper.score_many_against(rival, 2, subject)
    helper.score_many_against(subject, 4, rival)
    expect(subject.puntos).to eq 0
    expect(rival.puntos).to eq 0
  end

end