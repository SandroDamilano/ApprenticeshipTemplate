import DS from 'ember-data';
import UrlTemplates from "ember-data-url-templates";

export default DS.RESTAdapter.extend(UrlTemplates, {
  host: 'http://192.168.1.106:8080',
});
