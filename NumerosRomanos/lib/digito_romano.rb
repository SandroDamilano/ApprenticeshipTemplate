require 'digito_romano_nulo'

class DigitoRomano

  @digito
  @numero
  @digitoRestable
  @digitoSiguiente

  def numero()
    @numero
  end

  def addDigitoEn(unConversor)
    unConversor.agregarRomanoSumando(@digito, @numero)
  end

  def agregarDigitosSiCorresponde(unConversor)
    (unConversor.numeroArabigo / @numero).times do
      unConversor.agregarRomanoSumando(@digito, @numero)
    end
  end

  def agregarDigitosSiCorrespondeYContinuarSecuencia(unConversor)
    self.agregarDigitosSiCorresponde(unConversor)
    @digitoRestable.agregarDigitoRestandoSiCorresponde(unConversor, self)
    @digitoSiguiente.agregarDigitosSiCorrespondeYContinuarSecuencia(unConversor)
  end

  def canHandle(unDigitoRomano)
    unDigitoRomano == @digito
  end

  def agregarArabigo(unConversor)
    if(unConversor.numeroRomano.length > 1 && self.esMayorA(unConversor.numeroRomano[-2]))
      unConversor.agregarArabigoRestando(@digitoRestable.numero)
    end
    unConversor.agregarArabigoSumando(@numero)
    unConversor.realizarConversionANumerosArabigos()
  end

  def esMayorA(unCaracterRomano)
    digitosRomanos = self.class.DigitosRomanos
    numeroEquivalenteDelCaracter = digitosRomanos.detect{|digitoRomano| digitoRomano.canHandle(unCaracterRomano)}.numero
    return @numero > numeroEquivalenteDelCaracter
  end

  def initialize(caracterRomano, valor, digitoRestable, digitoSiguiente)
    @digito = caracterRomano
    @numero = valor
    @digitoRestable = digitoRestable
    @digitoSiguiente = digitoSiguiente
  end

  def self.DigitoM()
    return self.new('M', 1000, self.DigitoC, self.DigitoD)
  end

  def self.DigitoD()
    return self.new('D', 500, self.DigitoC, self.DigitoC)
  end

  def self.DigitoC()
    return DigitoRomanoRestable.new('C', 100, self.DigitoX, self.DigitoL)
  end

  def self.DigitoL()
    return self.new('L', 50, self.DigitoX, self.DigitoX)
  end

  def self.DigitoX()
    return DigitoRomanoRestable.new('X', 10, self.DigitoI, self.DigitoV)
  end

  def self.DigitoV()
    return self.new('V', 5, self.DigitoI, self.DigitoI)
  end

  def self.DigitoI()
    return DigitoRomanoRestable.new('I', 1, DigitoRomanoNulo.new(), DigitoRomanoNulo.new())
  end

  def self.DigitosRomanos()
    return Set.new([self.DigitoM, self.DigitoC, self.DigitoD, self.DigitoI, self.DigitoL, self.DigitoV, self.DigitoX])
  end

end