package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PollAdmin {

	private static final Logger logger = Logger.getLogger(PollAdmin.class.getName());
	private static final PollAdmin instance = new PollAdmin();
	private final List<Poll> polls = new ArrayList<>();
	private int lastId = 0;

	public static PollAdmin getInstance() {
		return instance;
	}

	private PollAdmin() {
		addPoll(new Poll("Favorite Color", "What is your personal favorite color?",
				new String[] {"Blue", "Green", "Red", "Purple", "Orange", "Yellow", "Pink", "Brown", "White", "Black"},
				LocalDate.of(2024, 2, 1)));
		addPoll(new Poll("Hamster Tax", "Do you support the introduction of a hamster tax?",
				new String[] {"Yes", "No", "Undecided"}, LocalDate.of(2024, 2, 5)));
		addPoll(new Poll("Silly Polls", "Would you agree to ban silly polls?",
				new String[] {"Yes", "Anyway", "Definitely"}, LocalDate.of(2024, 2, 10)));
	}

	public List<PollInfo> getPolls() {
		return polls.stream().map(poll -> new PollInfo(poll.getId(), poll.getTitle(), poll.getExpiration())).toList();
	}

	public List<PollInfo> getPolls(String poll_id) {
		List<PollInfo> pollList = new ArrayList<PollInfo>();
		for (Poll poll : polls) {
			if ((String.valueOf(poll.getId()).equals(poll_id))) {
				pollList.add(poll);
				return pollList
			}

					.equals(message.getTopic())) {
				filteredMessages.add(message);
			}
	}
//		return getMessages().stream()
//			.filter(message -> topic.equals(message.getTopic()))
//			.collect(Collectors.toList());



	public Poll findPoll(int id) throws PollNotFoundException {
		return polls.stream().filter(poll -> poll.getId() == id).findFirst()
				.orElseThrow(PollNotFoundException::new);
	}

	public void addPoll(Poll poll) {
		poll.setId(++lastId);
		polls.add(poll);
		logger.info("Poll " + poll.getId() + " added");
	}

	public void removePoll(int id) throws PollNotFoundException {
		Poll poll = findPoll(id);
		polls.remove(poll);
		logger.info("Poll " + poll.getId() + " removed");
	}
}
