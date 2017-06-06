import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('calendarios', function(){
    this.route('feriados', { path: '/:calendario_id' });
  });
});

export default Router;
