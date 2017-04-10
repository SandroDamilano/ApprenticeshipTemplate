require 'numero_invalido_exception'
require_relative '../lib/PosicionFibonacci/posicion_fibonacci'
require_relative 'proveedor_de_posiciones_fibonacci'

class CalculadorDeFibonacci

  @proveedorDePosicionesFibonacci

  def numeroFibonacciEnPosicion(unNumero)

    @proveedorDePosicionesFibonacci.obtenerPosicionDe(unNumero).calcularNumeroDeFibonacci

  end

  def initialize()
    @proveedorDePosicionesFibonacci = ProveedorDePosicionesFibonacci.new()
  end

end
