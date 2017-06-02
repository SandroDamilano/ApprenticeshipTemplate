import Ember from 'ember';

export function numbersBetween([start, end, ...params]) {
  var lowEnd = start;
  var highEnd = end;
  var arr = [];
  while(lowEnd <= highEnd){
    arr.push(lowEnd++);
  }
  return arr;
}

export default Ember.Helper.helper(numbersBetween);
