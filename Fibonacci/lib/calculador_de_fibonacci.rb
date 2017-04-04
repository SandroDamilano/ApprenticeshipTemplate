require 'numero_invalido_exception'
require_relative '../lib/PosicionFibonacci/posicion_fibonacci'

class CalculadorDeFibonacci

  def self.numeroFibonacciEnPosicion(unNumero)

    PosicionFibonacci.posicionDe(unNumero).calcularNumeroDeFibonacci

  end

end
