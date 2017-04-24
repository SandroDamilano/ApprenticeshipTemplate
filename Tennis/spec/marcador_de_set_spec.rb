require 'rspec'
require 'require_all'
require_all 'lib'

describe MarcadorDeSet do

  let(:rival) { MarcadorDeSet.new }

  it 'Cuando se inicializa un marcador de Set está en 0' do
    expect(subject.games).to eq 0
  end

  it 'Cuando un marcador suma un game, pasa a tener un game más' do
    subject.ganar_game_contra(rival)
    expect(subject.games).to eq 1
  end

  it 'Cuando un marcador con 5 games gana otro game, vuelve a tener 0 games' do
    sumar_games(subject, 5, rival)
    subject.ganar_game_contra(rival)
    expect(subject.games).to eq 0
  end

  it 'Cuando un marcador está igualado con otro y gana un game, pasa a tener 1 game más' do
    sumar_games(subject, 5, rival)
    sumar_games(rival, 5, subject)
    cantidad_de_games = subject.games
    subject.ganar_game_contra(rival)
    expect(subject.games).to eq cantidad_de_games + 1
  end

  it 'Cuando un marcador tiene menos games que otro y gana un game, pasa a tener 1 game más' do
    sumar_games(subject, 5, rival)
    sumar_games(rival, 6, subject)
    cantidad_de_games = subject.games
    subject.ganar_game_contra(rival)
    expect(subject.games).to eq cantidad_de_games + 1
  end

  it 'Cuando un marcador tiene más games que otro, y 5 games o más, y gana un game, pasa a tener 0 games' do
    sumar_games(subject, 5, rival)
    sumar_games(rival, 5, subject)
    subject.ganar_game_contra(rival)
    subject.ganar_game_contra(rival)
    expect(subject.games).to eq 0
  end

  def sumar_games(marcador_de_set, veces, otro_marcador_de_set)
    veces.times do
      marcador_de_set.ganar_game_contra(otro_marcador_de_set)
    end
  end

end