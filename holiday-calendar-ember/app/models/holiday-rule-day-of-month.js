import HolidayRule from './holiday-rule';
import DS from 'ember-data';

export default HolidayRule.extend({
  dayOfMonthHoliday: DS.attr('string'),
});
