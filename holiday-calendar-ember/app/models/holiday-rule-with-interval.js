import HolidayRule from './holiday-rule';
import DS from 'ember-data';

export default HolidayRule.extend({
  interval: DS.belongsTo('interval'),
  holidayRule: DS.belongsTo('holiday-rule', {polimorphic: true})
});
