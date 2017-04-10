require_relative '../lib/PosicionFibonacci/posicion_fibonacci_base'
require_relative '../lib/PosicionFibonacci/posicion_fibonacci_mayor_a_1'

class ProveedorDePosicionesFibonacci

  def obtenerPosicionDe(unNumero)
    posicionesDeFibonacci = [PosicionFibonacciBase.new(0), PosicionFibonacciBase.new(1), PosicionFibonacciMayorA1.new(unNumero)]
    return posicionesDeFibonacci.detect(lambda {raise NumeroInvalidoException, 'No se permite este número'}){|posicion| posicion.canHandle(unNumero)}
  end

end