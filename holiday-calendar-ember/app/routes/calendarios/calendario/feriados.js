import Ember from 'ember';

export default Ember.Route.extend({
  // Sacar para no tener los query params en la vista
  queryParams: {
    desde: {
      refreshModel: true
    },
    hasta: {
      refreshModel: true
    }
  },
  //

  model: function(params) {
    //@Migue: Como solucionamos esto?
    let calendario_id = this.paramsFor("calendarios.calendario").calendario_id;

    // Sacar para no tener los query params en la vista
    let desde = params.desde || '2017-01-01';
    let hasta = params.hasta || '2017-12-31';
    return this.get('store').query('feriado', {calendarioId: calendario_id, desde: desde, hasta: hasta});
    //

    // return this.get('store').query('feriado', {calendarioId: calendario_id});
  },
});
