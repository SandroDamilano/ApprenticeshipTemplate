class PosicionFibonacciMayorA1 < PosicionFibonacci

  @numero

  def self.canHandle(unNumero)
    (unNumero > 1) && (unNumero.modulo(1) == 0)
  end

  def initialize(unNumero)
    @numero = unNumero
  end

  def calcularNumeroDeFibonacci
    CalculadorDeFibonacci.numeroFibonacciEnPosicion(@numero - 1) + CalculadorDeFibonacci.numeroFibonacciEnPosicion(@numero - 2)
  end

end