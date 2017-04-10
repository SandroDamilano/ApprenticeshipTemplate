class PosicionFibonacciBase < PosicionFibonacci

  @numero

  def canHandle(unNumero)
    unNumero.equal?(@numero)
  end

  def calcularNumeroDeFibonacci
    @numero
  end

  def initialize(unNumero)
    @numero = unNumero
  end

end