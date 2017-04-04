class PosicionFibonacci

  def self.posicionDe(unNumero)
    self.subclases.detect(lambda {raise NumeroInvalidoException, 'No se permite este número'}){|posicion| posicion.canHandle(unNumero)}.new(unNumero)
  end

  def self.subclases
    ObjectSpace.each_object(Class).select { |klass| klass < self }
  end

  def initialize(unNumero)
  end
end