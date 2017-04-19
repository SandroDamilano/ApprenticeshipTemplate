class Cart

  def initialize
    @books = []
  end

  def empty?
    @books.empty?
  end

  def add(a_book)
    verify_editorial_for(a_book)
    @books << a_book
  end

  def include?(a_book)
    @books.include? a_book
  end

  def how_many_of?(a_book)
    @books.select{|each_book| each_book.eql? a_book}.length
  end

  def verify_editorial_for(a_book)
    if (a_book.editorial != 'Tus Libros')
      raise("El libro no es de la editorial")
    end
  end

end
