import Ember from 'ember';

export default Ember.Controller.extend({
  anioSeleccionado: Ember.computed(function(){
    return new Date().getFullYear();
  }),

  //Sacar para no tener los query params en la vista
  queryParams: ['desde', 'hasta'],
  //

  actions: {
    select(anio) {
      //Sacar para no tener los query params en la vista
      this.set('desde', anio + '-01-01');
      this.set('hasta', anio + '-12-31');
      //

      //   let calendario_id = this.paramsFor("calendarios.calendario").calendario_id;
      //   let desde = anio + '-01-01';
      //   let hasta = anio + '-12-31';
        // this.get('store').query('feriado', {calendarioId: calendario_id, desde: desde, hasta: hasta}).then( (result) => {
        //   this.set('model', result);
        // })
      }
  },
});
