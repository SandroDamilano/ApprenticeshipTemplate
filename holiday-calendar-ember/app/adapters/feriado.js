import ApplicationAdapter from './application';

export default ApplicationAdapter.extend({
  pathForType: function(type) {
    return 'calendarios/1/feriados';
  },

  // buildURL: function(feriado, calendario_id) {
  //     var url = this._super(feriado, calendario_id);
  //     debugger;
  //     return url;
  //   }
});
