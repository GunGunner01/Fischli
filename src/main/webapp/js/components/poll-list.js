import { Component } from './component.js';
import { service } from '../service.js';

export class PollList extends Component {

	static #template = `
		<h1>Polls</h1>
		<div id="polls"></div>
	`;

	constructor() {
		super('Polls', PollList.#template);
		service.getPolls().then(polls => this.#renderPolls(polls));
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
