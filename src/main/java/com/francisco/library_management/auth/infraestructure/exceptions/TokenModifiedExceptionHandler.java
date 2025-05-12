package com.francisco.library_management.auth.infraestructure.exceptions;

import java.io.IOException;

import org.springframework.stereotype.Component;


import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenModifiedExceptionHandler {

	public HttpServletResponse tokenModifiedExceptionHandle(HttpServletResponse response, Exception exception) {
	    try {
	    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		    response.setContentType("application/json");
			response.getWriter().write(exception.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return response;
	}
}
