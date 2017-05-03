class PosicionFibonacciMayorA1 < PosicionFibonacci

  @numero

  def canHandle(unNumero)
    (unNumero > 1) && (unNumero.modulo(1) == 0)
  end

  def initialize(unNumero)
    @numero = unNumero
  end

  def calcularNumeroDeFibonacci()
    primerNumeroAnterior = 0
    segundoNumeroAnterior = 0
    numeroDeFibbonacci = primerNumeroAnterior + segundoNumeroAnterior

    2..@numero.times do
      primerNumeroAnterior = numeroDeFibbonacci
      segundoNumeroAnterior = primerNumeroAnterior
      numeroDeFibbonacci = primerNumeroAnterior + segundoNumeroAnterior
    end

    numeroDeFibbonacci

  end

end