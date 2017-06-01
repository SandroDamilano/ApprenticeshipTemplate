import DS from 'ember-data';

export default DS.Model.extend({
  name: DS.attr('string'),
  holiday_rules: DS.hasMany('holiday-rule')
});
