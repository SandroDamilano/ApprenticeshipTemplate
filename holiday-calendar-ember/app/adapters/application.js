import DS from 'ember-data';

export default DS.RESTAdapter.extend({
  host: 'http://192.168.1.68:8080',

  pathForType: function(type) {
    return 'calendarios';
  }
  // namespace: '/calendarios'
});
