require 'digito_romano_nulo'
require 'digito_romano'

class ConversorDeNumerosRomanos

  @numeroArabigo
  @numeroRomano
  @digitoRomanoMayor

  def initialize()
    @digitoRomanoMayor = DigitoRomano.DigitoM
  end

  def toRomanos(unNumeroArabigo)

    @numeroArabigo = unNumeroArabigo
    @numeroRomano = ''

    @digitoRomanoMayor.agregarDigitosSiCorrespondeYContinuarSecuencia(self)

    return @numeroRomano

  end

  def agregarRomanoSumando(digitosRomanos, unNumero)
    @numeroRomano << digitosRomanos
    @numeroArabigo -= unNumero
  end

  def agregarRomanoRestando(digitosRomanos, unNumero)
    @numeroRomano << digitosRomanos
    @numeroArabigo += unNumero
  end

  def agregarArabigoSumando(unNumero)
    @numeroRomano = @numeroRomano.chop
    @numeroArabigo += unNumero
  end

  def agregarArabigoRestando(unNumero)
    @numeroRomano = @numeroRomano.chop
    @numeroArabigo -= unNumero
  end

  def numeroArabigo()
    @numeroArabigo
  end

  def numeroRomano()
    @numeroRomano
  end

  def toArabigos(unNumeroRomano)

    @numeroRomano = unNumeroRomano
    @numeroArabigo = 0

    self.realizarConversionANumerosArabigos()

    return @numeroArabigo
  end

  def realizarConversionANumerosArabigos()
    digitosRomanos = DigitoRomano.DigitosRomanos
    if(@numeroRomano[-1] != nil)
      ultimoDigitoAConvertir = @numeroRomano[-1]
      digitosRomanos.detect{|digitoRomano| digitoRomano.canHandle(ultimoDigitoAConvertir)}.agregarArabigo(self)
    end
  end

end