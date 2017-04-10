require 'rspec'
require_relative '../lib/calculador_de_fibonacci'
require_relative '../lib/PosicionFibonacci/posicion_fibonacci_mayor_a_1'
require_relative '../lib/PosicionFibonacci/posicion_fibonacci_base'

describe 'Calculador de números de fibonacci' do

  @calculadorDeFibonacci

  before(:each) do
    @calculadorDeFibonacci = CalculadorDeFibonacci.new()
  end

  it 'El número de fibonacci de una posición es la suma de los números de fibonacci de las 2 posiciones anteriores' do
    expect(@calculadorDeFibonacci.numeroFibonacciEnPosicion(8)).to eq(@calculadorDeFibonacci.numeroFibonacciEnPosicion(6) + @calculadorDeFibonacci.numeroFibonacciEnPosicion(7))
  end

  it 'El número de fibonacci de la posición 0 es 0' do
    expect(@calculadorDeFibonacci.numeroFibonacciEnPosicion(0)).to eq(0)
  end

  it 'El número de fibonacci de la posición 1 es 0' do
    expect(@calculadorDeFibonacci.numeroFibonacciEnPosicion(1)).to eq(1)
  end

  it 'El número de fibonacci en una posición negativa resulta en un error' do
    expect{@calculadorDeFibonacci.numeroFibonacciEnPosicion(-2)}.to raise_exception NumeroInvalidoException
  end

  it 'El número de fibonacci en una posición decimal resulta en un error' do
    expect{@calculadorDeFibonacci.numeroFibonacciEnPosicion(1.5)}.to raise_exception NumeroInvalidoException
  end

end