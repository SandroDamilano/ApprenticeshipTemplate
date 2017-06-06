import DS from 'ember-data';

export default DS.Model.extend({
  // fecha: DS.attr('string')
  anio: DS.attr('number'),
  mes: DS.attr('number'),
  dia: DS.attr('number')
});
