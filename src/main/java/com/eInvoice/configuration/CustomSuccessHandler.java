package com.eInvoice.configuration;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,Authentication authentication) throws IOException, ServletException {
		System.out.println("User Role : "+authentication);
		String targetUrl = determineTargetUrl(authentication);
	System.out.println("targetUrl : "+targetUrl);
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
	
	
	public String determineTargetUrl(Authentication authentication) {
		String url = "";

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();		
		List<String> roles = new ArrayList<String>();

		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());			
		}
		
		if (isAdmin(roles)) {
			url = "/pendingInvoice";
		} else{
			url = "/Access_Denied";
		}
		return url;
	}
	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ROLE_ADMIN")) {
			return true;
		}
		return false;
	}
	
	
}