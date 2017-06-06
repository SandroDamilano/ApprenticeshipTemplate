import ApplicationSerializer from './application';

export default ApplicationSerializer.extend({

  normalizeResponse(store, primaryModelClass, payload, id, requestType) {
    let normalizado = [];
    
    payload.forEach(function() {
      let feriado = {id: 915, anio: 2017, mes: 1, dia: 2};
      normalizado.push(feriado);
    });

    return this._super(store, primaryModelClass, normalizado, id, requestType);
  },
});
