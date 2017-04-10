class PosicionFibonacciMayorA1 < PosicionFibonacci

  @numero
  @proveedorDePosicionesFibonacci

  def canHandle(unNumero)
    (unNumero > 1) && (unNumero.modulo(1) == 0)
  end

  def initialize(unNumero)
    @numero = unNumero
    @proveedorDePosicionesFibonacci = ProveedorDePosicionesFibonacci.new()
  end

  def calcularNumeroDeFibonacci()
    CalculadorDeFibonacci.new().numeroFibonacciEnPosicion(@numero - 1) + CalculadorDeFibonacci.new().numeroFibonacciEnPosicion(@numero - 2)
  end

end