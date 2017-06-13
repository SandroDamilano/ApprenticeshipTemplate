import ApplicationSerializer from './application';

export default ApplicationSerializer.extend({
  serialize(snapshot, options) {
    let json = this._super(...arguments);
    debugger;
    if(!json.dayOfWeekHoliday){
      delete json.dayOfWeekHoliday;
    }
    if(json.dayOfMonthHoliday.indexOf('null') != -1){
      delete json.dayOfMonthHoliday;
    }
    if(!json.date){
      delete json.date;
    }

    return json;
  },
});
