class Book

  def initialize(an_editorial)
    @editorial = an_editorial
  end

  def editorial
    @editorial
  end

  # def ==(another_book)
  #   (another_book.instance_of? self.class) && (another_book.editorial.equal? self.editorial)
  # end

end