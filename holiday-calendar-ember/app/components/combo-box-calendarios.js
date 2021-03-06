import Ember from 'ember';

export default Ember.Component.extend({
  actions: {
    select(id) {
      this.get('onSelected')();
    }
  },

  didRender() {
    this._super(...arguments);
    $('select').material_select();
  }
});
