import Ember from 'ember';

export default Ember.Controller.extend({
  tipo: null,

  fechaFeriado: null,

  diaDelDiaDeMesFeriado: null,
  mesDelDiaDeMesFeriado: null,

  diaDeSemanaFeriado: null,

  vigenciaDesde: null,
  vigenciaHasta: null,

  actions:{
    selectDateHoliday(){
      this.set("tipo", "HolidayRuleDate");
    },
    selectDayOfWeekHoliday(){
      this.set("tipo", "HolidayRuleDayOfWeek");
    },
    selectDayOfMonthHoliday(){
      this.set("tipo", "HolidayRuleDayOfMonth");
    },
    submitHolidayRule(){
      let newHolidayRule = this.get('store').createRecord('holiday-rule', {
                            tipo: this.get('tipo'),
                            fechaFeriado: this.get('fechaFeriado'),
                            diaDelDiaDeMesFeriado: this.get('diaDelDiaDeMesFeriado'),
                            mesDelDiaDeMesFeriado: this.get('mesDelDiaDeMesFeriado'),
                            diaDeSemanaFeriado: this.get('diaDeSemanaFeriado')
                          });
      newHolidayRule.save({ adapterOptions: { calendario_id: this.model.query.calendarioId }});
    }
  }
});
