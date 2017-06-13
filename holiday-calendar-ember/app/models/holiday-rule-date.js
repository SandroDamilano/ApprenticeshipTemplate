import HolidayRule from './holiday-rule';
import DS from 'ember-data';

export default HolidayRule.extend({
  date: DS.attr('string'),
});
