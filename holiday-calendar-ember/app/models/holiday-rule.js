import DS from 'ember-data';

export default DS.Model.extend({
  tipo: DS.attr('string'),

  fechaFeriado: DS.attr('string'),

  diaDelDiaDeMesFeriado: DS.attr('number'),
  mesDelDiaDeMesFeriado: DS.attr('string'),

  diaDeSemanaFeriado: DS.attr('string'),

  vigenciaDesde: DS.attr('string'),
  vigenciaHasta: DS.attr('string')
});
