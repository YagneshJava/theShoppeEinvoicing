package com.eInvoice.configuration;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String lastUserName = request.getParameter("ssoId");

		System.out.println("Error is "+exception.getMessage());
		System.out.println("call failure");
		
		RequestDispatcher rd = request.getRequestDispatcher("/login?error");
		request.setAttribute("error", exception.getMessage());
		rd.forward(request, response);
	}

}
