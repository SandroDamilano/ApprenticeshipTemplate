require 'rspec'
require_relative '../lib/conversor_de_numeros_romanos'

describe 'Numeros Romanos' do

  @conversor

  before(:each) do
    @conversor = ConversorDeNumerosRomanos.new
  end

  it '1 en números romanos es I' do
    expect(@conversor.toRomanos(1)).to eq('I')
  end

  it '2 en números romanos es II' do
    expect(@conversor.toRomanos(2)).to eq('II')
  end

  it '3 en números romanos es III' do
    expect(@conversor.toRomanos(3)).to eq('III')
  end

  it '4 en números romanos es IV' do
    expect(@conversor.toRomanos(4)).to eq('IV')
  end

  it '5 en números romanos es V' do
    expect(@conversor.toRomanos(5)).to eq('V')
  end

  it '6 en números romanos es VI' do
    expect(@conversor.toRomanos(6)).to eq('VI')
  end

  it '7 en números romanos es VII' do
    expect(@conversor.toRomanos(7)).to eq('VII')
  end

  it '8 en números romanos es VIII' do
    expect(@conversor.toRomanos(8)).to eq('VIII')
  end

  it '9 en números romanos es IX' do
    expect(@conversor.toRomanos(9)).to eq('IX')
  end

  it '10 en números romanos es X' do
    expect(@conversor.toRomanos(10)).to eq('X')
  end

  it '11 en números romanos es XI' do
    expect(@conversor.toRomanos(11)).to eq('XI')
  end

  it '12 en números romanos es XII' do
    expect(@conversor.toRomanos(12)).to eq('XII')
  end

  it '13 en números romanos es XIII' do
    expect(@conversor.toRomanos(13)).to eq('XIII')
  end

  it '14 en números romanos es XIV' do
    expect(@conversor.toRomanos(14)).to eq('XIV')
  end

  it '15 en números romanos es XV' do
    expect(@conversor.toRomanos(15)).to eq('XV')
  end

  it '16 en números romanos es XVI' do
    expect(@conversor.toRomanos(16)).to eq('XVI')
  end

  it '17 en números romanos es XVII' do
    expect(@conversor.toRomanos(17)).to eq('XVII')
  end

  it '18 en números romanos es XVIII' do
    expect(@conversor.toRomanos(18)).to eq('XVIII')
  end

  it '19 en números romanos es XIX' do
    expect(@conversor.toRomanos(19)).to eq('XIX')
  end

  it '20 en números romanos es XX' do
    expect(@conversor.toRomanos(20)).to eq('XX')
  end

  it '21 en números romanos es XXI' do
    expect(@conversor.toRomanos(21)).to eq('XXI')
  end

  it '22 en números romanos es XXII' do
    expect(@conversor.toRomanos(22)).to eq('XXII')
  end

  it '24 en números romanos es XXIV' do
    expect(@conversor.toRomanos(24)).to eq('XXIV')
  end

  it '25 en números romanos es XXV' do
    expect(@conversor.toRomanos(25)).to eq('XXV')
  end

  it '26 en números romanos es XXVI' do
    expect(@conversor.toRomanos(26)).to eq('XXVI')
  end

  it '29 en números romanos es XXIX' do
    expect(@conversor.toRomanos(29)).to eq('XXIX')
  end

  it '30 en números romanos es XXX' do
    expect(@conversor.toRomanos(30)).to eq('XXX')
  end

  it '31 en números romanos es XXXI' do
    expect(@conversor.toRomanos(31)).to eq('XXXI')
  end

  it '34 en números romanos es XXXIV' do
    expect(@conversor.toRomanos(34)).to eq('XXXIV')
  end

  it '35 en números romanos es XXXV' do
    expect(@conversor.toRomanos(35)).to eq('XXXV')
  end

  it '36 en números romanos es XXXVI' do
    expect(@conversor.toRomanos(36)).to eq('XXXVI')
  end

  it '39 en números romanos es XXXIX' do
    expect(@conversor.toRomanos(39)).to eq('XXXIX')
  end

  it '40 en números romanos es XL' do
    expect(@conversor.toRomanos(40)).to eq('XL')
  end

  it '41 en números romanos es XLI' do
    expect(@conversor.toRomanos(41)).to eq('XLI')
  end

  it '42 en números romanos es XLII' do
    expect(@conversor.toRomanos(42)).to eq('XLII')
  end

  it '44 en números romanos es XLIV' do
    expect(@conversor.toRomanos(44)).to eq('XLIV')
  end

  it '45 en números romanos es XLV' do
    expect(@conversor.toRomanos(45)).to eq('XLV')
  end

  it '46 en números romanos es XLVI' do
    expect(@conversor.toRomanos(46)).to eq('XLVI')
  end

  it '49 en números romanos es XLIX' do
    expect(@conversor.toRomanos(49)).to eq('XLIX')
  end

  it '50 en números romanos es L' do
    expect(@conversor.toRomanos(50)).to eq('L')
  end

  it '54 en números romanos es LIV' do
    expect(@conversor.toRomanos(54)).to eq('LIV')
  end

  it '56 en números romanos es LVI' do
    expect(@conversor.toRomanos(56)).to eq('LVI')
  end

  it '59 en números romanos es LIX' do
    expect(@conversor.toRomanos(59)).to eq('LIX')
  end

  it '61 en números romanos es LXI' do
    expect(@conversor.toRomanos(61)).to eq('LXI')
  end

  it '89 en números romanos es LXXXIX' do
    expect(@conversor.toRomanos(89)).to eq('LXXXIX')
  end

  it '90 en números romanos es XC' do
    expect(@conversor.toRomanos(90)).to eq('XC')
  end

  it '99 en números romanos es XCIX' do
    expect(@conversor.toRomanos(99)).to eq('XCIX')
  end

  it '349 en números romanos es CCCXLIX' do
    expect(@conversor.toRomanos(349)).to eq('CCCXLIX')
  end

  it '3000 en números romanos es MMM' do
    expect(@conversor.toRomanos(3000)).to eq('MMM')
  end

  it '3001 en números romanos es MMMI' do
    expect(@conversor.toRomanos(3001)).to eq('MMMI')
  end

  it '3999 en números romanos es MMMCMXCIX' do
    expect(@conversor.toRomanos(3999)).to eq('MMMCMXCIX')
  end

  ################################################################################################################

  it 'I en números arábigos es 1' do
    expect(@conversor.toArabigos('I')).to eq(1)
  end

  it 'III en números arábigos es 3' do
    expect(@conversor.toArabigos('III')).to eq(3)
  end

  it 'IV en números arábigos es 4' do
    expect(@conversor.toArabigos('IV')).to eq(4)
  end

  it 'VI en números arábigos es 6' do
    expect(@conversor.toArabigos('VI')).to eq(6)
  end

  it 'VI en números arábigos es 6' do
    expect(@conversor.toArabigos('VI')).to eq(6)
  end

  it 'XIV en números arábigos es 14' do
    expect(@conversor.toArabigos('XIV')).to eq(14)
  end

  it 'MMMCMXCIX en números arábigos es 3999' do
    expect(@conversor.toArabigos('MMMCMXCIX')).to eq(3999)
  end

end