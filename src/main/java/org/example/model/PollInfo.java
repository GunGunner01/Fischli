package org.example.model;

import java.time.LocalDate;

public record PollInfo(int id, String title, LocalDate expiration) {
}
