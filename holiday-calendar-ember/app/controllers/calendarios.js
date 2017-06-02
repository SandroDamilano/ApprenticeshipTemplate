import Ember from 'ember';

export default Ember.Controller.extend({
  actions: {
    saludar() {
      this.set('saludarOK', true);
    },

    mostrarAnios(){
      this.set('aniosOK', true);
    }
  }
});
