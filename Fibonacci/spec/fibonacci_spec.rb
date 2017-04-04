require 'rspec'
require_relative '../lib/calculador_de_fibonacci'
require_relative '../lib/PosicionFibonacci/posicion_fibonacci_mayor_a_1'
require_relative '../lib/PosicionFibonacci/posicion_fibonacci0'
require_relative '../lib/PosicionFibonacci/posicion_fibonacci1'

describe 'fibonacci' do

  it 'PosicionFibonacciMayorA1 está dentro de las subclases de PosicionFibonacci' do
    expect(PosicionFibonacci.subclases.include?(PosicionFibonacci1)).to be_truthy
  end

  it 'PosicionFibonacciMayorA1 está dentro de las subclases de PosicionFibonacci' do
    expect(PosicionFibonacci.subclases.length).to eq(3)
  end

  it 'El número de fibonacci de una posición es la suma de los números de fibonacci de las 2 posiciones anteriores' do
    expect(CalculadorDeFibonacci.numeroFibonacciEnPosicion(8)).to eq(CalculadorDeFibonacci.numeroFibonacciEnPosicion(6) + CalculadorDeFibonacci.numeroFibonacciEnPosicion(7))
  end

  it 'El número de fibonacci de la posición 0 es 0' do
    expect(CalculadorDeFibonacci.numeroFibonacciEnPosicion(0)).to eq(0)
  end

  it 'El número de fibonacci de la posición 1 es 0' do
    expect(CalculadorDeFibonacci.numeroFibonacciEnPosicion(1)).to eq(0)
  end

  it 'El número de fibonacci en una posición negativa resulta en un error' do
    expect{CalculadorDeFibonacci.numeroFibonacciEnPosicion(-2)}.to raise_exception NumeroInvalidoException
  end

  it 'El número de fibonacci en una posición decimal resulta en un error' do
    expect{CalculadorDeFibonacci.numeroFibonacciEnPosicion(1.5)}.to raise_exception NumeroInvalidoException
  end

end