require 'rspec'
require 'require_all'
require_all 'lib'

describe 'Shopping cart' do

  let(:cart) {Cart.new}

  context 'Cuando se crea un carrito' do
    it 'Debería estar vacío' do
      expect(cart.empty?).to be_truthy
    end
  end

  context 'Cuando se agrega un libro a un carrito vacio' do
    let(:book) {Book.new('Tus Libros')}

    it 'Ya no debería estar vacío' do
      cart.add(book)
      expect(cart.empty?).to be_falsey
    end

    it 'El carrito deberia contener el mismo libro' do
      cart.add(book)
      expect(cart.include? book).to be_truthy
    end
  end

  context 'Cuando se agregan dos libros a un carrito' do
    # let(:cart) { a_cart }

    it 'Debería contener ambos libros' do
      a_book = Book.new('Tus Libros')
      another_book = Book.new('Tus Libros')
      cart.add(a_book)
      cart.add(another_book)
      expect(cart.include?a_book).to be_truthy
      expect(cart.include?another_book).to be_truthy
    end
  end

  context 'Cuando se agregan dos ejemplares del mismo libro a un carrito' do
    it 'Debería contener el mismo libro 2 veces' do
      a_book = Book.new('Tus Libros')
      cart.add(a_book)
      cart.add(a_book)
      expect(cart.how_many_of? a_book).to eq(2)
    end
  end

  context 'Cuando se intenta agregar un libro que no es de la editorial al carrito' do
    it 'Debería ocurrir un error' do
      non_editorial_book = Book.new('Alfawara')
      expect{cart.add(non_editorial_book)}.to raise_error("El libro no es de la editorial")
    end
  end

end