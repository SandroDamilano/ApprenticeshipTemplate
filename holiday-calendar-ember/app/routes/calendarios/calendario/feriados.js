import Ember from 'ember';

export default Ember.Route.extend({
  model: function(params, transition) {
    let calendario_id = transition.params["calendarios.calendario"].calendario_id;
    return this.get('store').query('feriado', {calendarioId: calendario_id});
  }
});
