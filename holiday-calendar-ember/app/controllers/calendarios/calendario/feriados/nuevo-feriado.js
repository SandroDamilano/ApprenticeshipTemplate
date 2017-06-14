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

    selectDayOfWeek(aDayOfWeek){
      this.set("diaDeSemanaFeriado", aDayOfWeek);
    },

    submitHolidayRule(){
      let newHolidayRule = this.get('store').createRecord('holiday-rule', {
        type: this.get('tipo'),
        dayOfWeekHoliday: this.get('diaDeSemanaFeriado'),
        date: this.get('fechaFeriado'),
        dayFromDayOfMonthHoliday: this.get('diaDelDiaDeMesFeriado'),
        monthFromDayOfMonthHoliday: this.get('mesDelDiaDeMesFeriado'),
      });

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
