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
      debugger;
      if(this.get('tipo') == 'HolidayRuleDayOfWeek'){
        let newHolidayRule = this.get('store').createRecord('holiday-rule-day-of-week', {
          type: this.get('tipo'),
          dayOfWeekHoliday: this.get('diaDeSemanaFeriado')
        });
        newHolidayRule.save({ adapterOptions: { calendario_id: this.model.query.calendarioId }});
      }

      if(this.get('tipo') == 'HolidayRuleDate'){
        let newHolidayRule = this.get('store').createRecord('holiday-rule-date', {
          type: this.get('tipo'),
          date: this.get('fechaFeriado')
        });
        newHolidayRule.save({ adapterOptions: { calendario_id: this.model.query.calendarioId }});
      }

      if(this.get('tipo') == 'HolidayRuleDayOfMonth'){
        let newHolidayRule = this.get('store').createRecord('holiday-rule-day-of-month', {
          type: this.get('tipo'),
          dayOfMonthHoliday: '--' + this.get('mesDelDiaDeMesFeriado') + '-' + this.get('diaDelDiaDeMesFeriado'),
        });
        newHolidayRule.save({ adapterOptions: { calendario_id: this.model.query.calendarioId }});
      }

    }
  }
});
