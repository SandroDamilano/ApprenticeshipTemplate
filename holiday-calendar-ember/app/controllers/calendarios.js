import Ember from 'ember';

export default Ember.Controller.extend({
  calendarioSeleccionado: null,

  actions: {
    seleccionar(unCalendario){
      this.set('calendarioSeleccionado', unCalendario);
    }
  }
});
