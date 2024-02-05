package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet("/api/votes")
public class VoteServlet extends HttpServlet {

    private static final String JSON_MEDIA_TYPE = "application/json";
    private static final ObjectMapper objectMapper = ObjectMapperFactory.createObjectMapper();
    private static final PollAdmin pollAdmin = PollAdmin.getInstance();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            int poll_id = Integer.parseInt(request.getParameter("pollId"));
            String option = request.getParameter("option");

            Poll poll = pollAdmin.findPoll(poll_id);

            LocalDate now = LocalDate.from(LocalDateTime.now());

            if (now.isBefore(poll.getExpiration())) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            Vote vote = new Vote(poll_id, option);

            poll.addVote(option);

            response.setStatus(HttpServletResponse.SC_CREATED);
        } catch (PollNotFoundException | InvalidVoteException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
