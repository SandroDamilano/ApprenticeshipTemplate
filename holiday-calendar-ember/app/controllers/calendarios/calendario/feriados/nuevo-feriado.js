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

    }
  }
});
