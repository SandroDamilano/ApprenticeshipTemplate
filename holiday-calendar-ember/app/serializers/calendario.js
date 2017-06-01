import DS from 'ember-data';

export default DS.JSONSerializer.extend({
  // serialize(snapshot, options) /*No se porque van estos argumentos*/ {
  //   var json = this._super(...arguments);
  //
  //   json.data.attributes.calendario = {
  //     id: json.data.attributes.id,
  //     name: json.data.attributes.name,
  //     holiday_rules: json.data.attributes.holiday_rules
  //   };
  //
  //   delete json.data.attributes.id;
  //   delete json.data.attributes.name;
  //   delete json.data.attributes.holiday_rules;
  //
  //   return json;
  // },

  // normalizeResponse(store, primaryModelClass, payload, id, requestType) {
  //   payload.calendario = {
  //     id: payload.id,
  //     name: payload.name,
  //     holidayRules: payload.holidayRules
  //   }
  //
  //   delete payload.id;
  //   delete payload.name;
  //   delete payload.holidayRules;
  //
  //   return this._super(...arguments);
  // },
});
