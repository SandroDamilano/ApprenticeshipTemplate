// import HolidayRule from './holiday-rule';
import DS from 'ember-data';

export default DS.Model.extend({
  type: DS.attr('string'),
  interval: DS.belongsTo('interval'),
  holidayRule: DS.belongsTo('holiday-rule', {polimorphic: true})
});
