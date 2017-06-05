import { moduleForComponent, test } from 'ember-qunit';
import hbs from 'htmlbars-inline-precompile';

moduleForComponent('combo-box-calendarios', 'Integration | Component | combo box calendarios', {
  integration: true
});

test('it renders', function(assert) {

  // Set any properties with this.set('myProperty', 'value');
  // Handle any actions with this.on('myAction', function(val) { ... });

  this.render(hbs`{{combo-box-calendarios}}`);

  assert.equal(this.$().text().trim(), '');

  // Template block usage:
  this.render(hbs`
    {{#combo-box-calendarios}}
      template block text
    {{/combo-box-calendarios}}
  `);

  assert.equal(this.$().text().trim(), 'template block text');
});
