import ApplicationAdapter from './application';

export default ApplicationAdapter.extend({
  queryUrlTemplate: '{+host}/calendarios/{calendarioId}/feriados{?desde,hasta}',
});
