import Ember from 'ember';

export default Ember.Route.extend({
  model(params) {
    return this.get('store').findAll('feriado');
    // return this.get('store').findRecord('calendarios', params.calendario_id);
  }
});
