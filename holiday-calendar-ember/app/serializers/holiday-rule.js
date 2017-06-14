import ApplicationSerializer from './application';

export default ApplicationSerializer.extend({
  serialize(snapshot, options) {
    let json = this._super(...arguments);
    if(!json.dayOfWeekHoliday){
      delete json.dayOfWeekHoliday;
    }
    if(json.dayFromDayOfMonthHoliday && json.monthFromDayOfMonthHoliday){
      json.dayOfMonthHoliday = '--' + json.monthFromDayOfMonthHoliday + '-' + json.dayFromDayOfMonthHoliday;
    }
    if(!json.date){
      delete json.date;
    }

    delete json.dayFromDayOfMonthHoliday;
    delete json.monthFromDayOfMonthHoliday;

    return json;
  },
});
