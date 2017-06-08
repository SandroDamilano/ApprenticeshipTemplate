import Ember from 'ember';

export default Ember.Component.extend({
  actions: {
    select(value) {
      this.get('onSelected')(value);
    }
  },

  didRender() {
    this._super(...arguments);
    $('select').material_select();
  }

});
