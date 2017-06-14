import Ember from 'ember';

export default Ember.Component.extend({
  didRender(){
    this._super(...arguments);
    $('.datepicker').pickadate({
      selectMonths: true, // Creates a dropdown to control month
      selectYears: 15, // Creates a dropdown of 15 years to control year
      format: 'yyyy-mm-dd',
      closeOnSelect: true
    });
  }
});
