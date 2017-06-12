import ApplicationAdapter from './application';

export default ApplicationAdapter.extend({
  createRecordUrlTemplate: '{+host}/calendarios/{calendario_id}/reglas_de_feriado',

  urlSegments:{
    calendario_id: function(type, id, snapshot, query) {
      return snapshot.adapterOptions.calendario_id;
    },
  }
});
