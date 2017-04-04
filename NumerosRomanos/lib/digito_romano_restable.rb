require 'digito_romano'

class DigitoRomanoRestable < DigitoRomano

  def agregarDigitoRestandoSiCorresponde(unConversor, unDigitoRomano)
    if(((unConversor.numeroArabigo + @numero) / @numero).modulo(unDigitoRomano.numero/@numero) == 0 )
      unConversor.agregarRomanoRestando(@digito, @numero)
      unDigitoRomano.addDigitoEn(unConversor)
    end
  end

end