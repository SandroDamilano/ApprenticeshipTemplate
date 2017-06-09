import DS from 'ember-data';

export default DS.Model.extend({
  tipo: DS.attr('string'),

  fechaFeriado: DS.attr('string'),

  DiaDelDiaDeMesFeriado: DS.attr('number'),
  MesDelDiaDeMesFeriado: DS.attr('string'),

  DiaDeSemanaFeriado: DS.attr('string'),

  vigenciaDesde: DS.attr('string'),
  vigenciaHasta: DS.attr('string')
});
