import Ember from 'ember';

export default Ember.Controller.extend({
  tipo: null,

  fechaFeriado: null,

  DiaDelDiaDeMesFeriado: null,
  MesDelDiaDeMesFeriado: null,

  DiaDeSemanaFeriado: null,

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
    }
  }
});
