import Ember from 'ember';

export default Ember.Component.extend({
  actions: {
    select(value) {
      this.get('onSelected')();
    }
  }

});
