import ApplicationSerializer from './application';

export default ApplicationSerializer.extend({

  normalizeResponse(store, primaryModelClass, payload, id, requestType) {
    let normalizado = payload.map((_feriado, index) => {
      return {id: index,
              dia: _feriado.substr(8, 2),
              mes: _feriado.substr(5, 2),
              anio: _feriado.substr(0, 4)}
    });

    return this._super(store, primaryModelClass, normalizado, id, requestType);
  },
});
