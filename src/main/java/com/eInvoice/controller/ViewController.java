package com.eInvoice.controller;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	
	@GetMapping(value = { "/"})
	public String getIndexPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login" )	
	public ModelAndView loginPage(String error , @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request ) throws UnknownHostException {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
	    return model;
	}
	
	@GetMapping("/userDashboard")
	public String getDashboardPage() {
		return "user/userDashboard";
	}
	
	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			SecurityContextLogoutHandler x = new SecurityContextLogoutHandler();
			x.setInvalidateHttpSession(true);
			x.setClearAuthentication(true);
			x.logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
}
