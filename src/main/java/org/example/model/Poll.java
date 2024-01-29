package org.example.model;

import java.time.LocalDate;
import java.util.Arrays;

public class Poll {

	private Integer id;
	private String title;
	private String question;
	private String[] options;
	private LocalDate expiration;
	private int[] numVotes;

	public Poll() {
	}

	public Poll(String title, String question, String[] options, LocalDate expiration) {
		this.title = title;
		this.question = question;
		this.options = options;
		this.expiration = expiration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getQuestion() {
		return question;
	}

	public String[] getOptions() {
		return options;
	}

	public LocalDate getExpiration() {
		return expiration;
	}

	public int[] getNumVotes() {
		return numVotes;
	}

	public void addVote(String option) throws InvalidVoteException {
		int index = Arrays.asList(options).indexOf(option);
		if (index < 0) {
			throw new InvalidVoteException();
		}
		if (numVotes == null) numVotes = new int[options.length];
		numVotes[index]++;
	}
}
