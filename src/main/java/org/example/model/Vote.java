package org.example.model;

public class Vote {
    Integer poll_id;
    String option;

    public Vote(Integer poll_id, String option) {
        this.poll_id = poll_id;
        this.option = option;
    }
}
