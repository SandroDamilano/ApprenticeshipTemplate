import HolidayRule from './holiday-rule';

export default HolidayRule.extend({
  vigenciaDesde: DS.attr('string'),
  vigenciaHasta: DS.attr('string'),
  reglaDeFeriado: DS.belongsTo('holiday-rule', {polimorphic: true})
});
