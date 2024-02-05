package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Poll;
import org.example.model.PollAdmin;
import org.example.model.PollInfo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/polls")
public class PollServlet extends HttpServlet {

	private static final String JSON_MEDIA_TYPE = "application/json";
	private static final ObjectMapper objectMapper = ObjectMapperFactory.createObjectMapper();
	private static final PollAdmin pollAdmin = PollAdmin.getInstance();

	// http://localhost:8080/api/polls?poll_id=2
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String poll_id = request.getParameter("poll_id");
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType(JSON_MEDIA_TYPE);
			List<PollInfo> polls = pollAdmin.getPolls(poll_id);
		objectMapper.writeValue(response.getOutputStream(), polls);
	}

}
