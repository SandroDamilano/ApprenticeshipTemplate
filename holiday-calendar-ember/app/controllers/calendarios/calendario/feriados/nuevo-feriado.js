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
      let newHolidayRule;
      if(this.get('tipo') == 'HolidayRuleDayOfWeek'){
        newHolidayRule = this.get('store').createRecord('holiday-rule-day-of-week', {
          type: this.get('tipo'),
          dayOfWeekHoliday: this.get('diaDeSemanaFeriado')
        });
      }

      if(this.get('tipo') == 'HolidayRuleDate'){
        newHolidayRule = this.get('store').createRecord('holiday-rule-date', {
          type: this.get('tipo'),
          date: this.get('fechaFeriado')
        });
      }

      if(this.get('tipo') == 'HolidayRuleDayOfMonth'){
        newHolidayRule = this.get('store').createRecord('holiday-rule-day-of-month', {
          type: this.get('tipo'),
          dayOfMonthHoliday: '--' + this.get('mesDelDiaDeMesFeriado') + '-' + this.get('diaDelDiaDeMesFeriado'),
        });
      }

      let desde = this.get('vigenciaDesde');
      let hasta = this.get('vigenciaHasta');
      if(desde && hasta){ // Chequea que no sean nulos
        let innerHolidayRule = newHolidayRule;
        let anInterval = this.get('store').createRecord('interval', {
          start: desde,
          end: hasta
        })
        newHolidayRule = this.get('store').createRecord('holiday-rule-with-interval', {
          type: 'HolidayRuleWithInterval',
          interval: anInterval,
          holidayRule: innerHolidayRule
        })
      }

       newHolidayRule.save({ adapterOptions: { calendario_id: this.model.query.calendarioId }});
    }
  }
});
