package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.PollAdmin;
import org.example.model.Vote;

import java.io.IOException;

@WebServlet("/api/votes")
public class VoteServlet extends HttpServlet {

    private static final String JSON_MEDIA_TYPE = "application/json";
    private static final ObjectMapper objectMapper = ObjectMapperFactory.createObjectMapper();
    private static final PollAdmin pollAdmin = PollAdmin.getInstance();

//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String poll_id = request.getParameter("poll_id");
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.setContentType(JSON_MEDIA_TYPE);
//        List<PollInfo> polls = pollAdmin.getPolls(poll_id);
//        objectMapper.writeValue(response.getOutputStream(), polls);
//    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {





          String poll_id = request.getParameter("pollId");
          String option = request.getParameter("option");

          Vote vote = new Vote(Integer.parseInt(poll_id), option);

//            ChatMessage message = objectMapper.readValue(request.getInputStream(), ChatMessage.class);
//            if (message.getId() != null || message.getText() == null || message.getText().isEmpty()) {
//                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                return;
//            }
//            // add message
//            logger.info("Adding message");
//            chatService.addMessage(message);
//            response.setStatus(HttpServletResponse.SC_CREATED);
//            response.setContentType("application/json");
//            objectMapper.writeValue(response.getOutputStream(), message);
        } catch (JsonProcessingException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
