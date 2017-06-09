import ApplicationAdapter from './application';

export default ApplicationAdapter.extend({
  createRecordUrlTemplate: '{+host}/calendarios/{calendarioId}/reglas_de_feriado'
});
