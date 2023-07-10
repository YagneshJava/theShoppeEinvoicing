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
		System.out.println("manufacturerQuotationPage Role : "+authentication);
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
		
		if(isPending(roles)) {
			url = "/welcomePendingPage";
		}else if (isAdmin(roles)) {
			url = "/userDashboard";
		} else if (isCustomer(roles)) {
			url = "/wellcomeCustomer";
		} else if (isSupplier(roles)) {
			url = "/wellcomeSupplier";
		}else if (isDispensingVerify(roles)) {
			url = "/wellcomeDispensingRegistration";
//			url = "/dispensingDocRegistration";
		}else if (isPharmacyVerify(roles)) {
			url = "/wellcomePharmacyRegistration";
		}else if (isWhoVerify(roles)) {
			url = "/wellcomeCustomerRegistration";
		}else if (isSupplierVerify(roles)) {
			url = "/wellcomeSupplierRegistration";
		}else if (isManufacturer(roles)) {
			url = "/manufacturerWelcome";
		}else if(isManufacturerVerify(roles)) {
			url = "/welcomeManufacturerRegistration";
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
	private boolean isCustomer(List<String> roles) {
		if (roles.contains("ROLE_CUSTOMER")) {
			return true;
		}
		return false;
	}
	
	private boolean isSupplier(List<String> roles) {
		if (roles.contains("ROLE_SUPPLIER")) {
			return true;
		}
		return false;
	}
	
	
	private boolean isSupplierVerify(List<String> roles) {
		if (roles.contains("ROLE_SUPPLIER_VERIFY")) {
			return true;
		}
		return false;
	}
	
	private boolean isWhoVerify(List<String> roles) {
		if (roles.contains("ROLE_WHOLESALECUSTOMER_VERIFY")) {
			return true;
		}
		return false;
	}
	
	private boolean isPharmacyVerify(List<String> roles) {
		if (roles.contains("ROLE_PHARMACY_VERIFY")) {
			return true;
		}
		return false;
	}
	
	private boolean isDispensingVerify(List<String> roles) {
		if (roles.contains("ROLE_DISPENSINGDOCTOR_VERIFY")) {
			return true;
		}
		return false;
	}
	
	private boolean isPending(List<String> roles) {
		if (roles.contains("ROLE_PENDING")) {
			return true;
		}
		return false;
	}
	
	private boolean isManufacturer(List<String> roles) {
		if (roles.contains("ROLE_MANUFACTURER")) {
			return true;
		}
		return false;
	}
	
	private boolean isManufacturerVerify(List<String> roles) {
		if (roles.contains("ROLE_MANUFACTURER_VERIFY")) {
			return true;
		}
		return false;
	}
	
}