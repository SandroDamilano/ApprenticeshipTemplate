import Ember from 'ember';

export function listaNumerosEntre([inicio, fin, ...params]) {
  var lowEnd = inicio;
  var highEnd = fin;
  var arr = [];
  while(lowEnd <= highEnd){
    arr.push(lowEnd++);
  }
  return arr;
}

export default Ember.Helper.helper(listaNumerosEntre);
