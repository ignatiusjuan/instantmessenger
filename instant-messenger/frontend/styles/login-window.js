import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class LoginWindow extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing">
  <vaadin-text-field label="Label" placeholder="Placeholder" style="flex-grow: 0; flex-shrink: 1;"></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing">
  <vaadin-text-field label="Label" placeholder="Placeholder"></vaadin-text-field>
  <vaadin-text-field label="Label" placeholder="Placeholder"></vaadin-text-field>
  <vaadin-text-field label="Label" placeholder="Placeholder"></vaadin-text-field>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'login-window';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(LoginWindow.is, LoginWindow);
