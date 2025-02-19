package org.example.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter("/api/*")
public class LoggingFilter extends HttpFilter {

	private static final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String requestLine = request.getMethod() + " " + request.getRequestURI();
		if (request.getQueryString() != null) {
			requestLine += "?" + request.getQueryString();
		}
		logger.info("HTTP request: " + requestLine);
		chain.doFilter(request, response);
		logger.info("HTTP response: " + response.getStatus());
	}
}
