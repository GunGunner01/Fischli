import { Component } from './component.js';
import { service } from '../service.js';

export class Poll extends Component {

    static #template = `
		<h1 id="poll-title">Hamster Tax</h1>
		<form action="/api/votes">
            <label for="poll-options">Do you support the introduction of a hamster tax?</label>
            <select name="poll-options">
                <option value="opt_1">Yes</option>
                <option value="opt_2">No</option>
                <option value="opt_3">Undecided</option>
            </select>
        
            <input type="submit">
		    <button onclick="history.back()">Cancel</button>
		</form>
	`;

    constructor(poll) {
        super('Poll', Poll.#template);
        service.getPoll(poll).then(polls => this.#renderPoll(poll))
    }

    #renderPoll(poll) {
        let pollOptionsElement = this._select('#poll-options');

        document.getElementById("poll-title").textContent="Hamster Tax";

        // ich weis, dieser teil muss noch gemacht werden.
        // Es benötigt einen foreach loop, der über alle optionen der Poll Frage loopt und
        // den code unten ausführt.
        let pollOption = document.createElement('option')
        pollOptionsElement.innerHTML = 'Yes';
        pollOptionsElement.value = 'Yes';
        pollOption.append(pollOptionsElement);

    }
}
