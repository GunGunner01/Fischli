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

    constructor(pollId) {
        super('Poll', Poll.#template);
        service.
        // service.getPolls().then(polls => this.#renderPolls(polls));
    }

    #renderPolls(polls) {
        let list = this._select('#polls');
        if (polls.length === 0)
            list.innerHTML = 'No polls available';
        else polls.forEach(poll => {
            let item = document.createElement('div');
            item.innerHTML = `<b>${poll.title}</b> (until ${poll.expiration})`;
            list.append(item);
        });
    }
}
