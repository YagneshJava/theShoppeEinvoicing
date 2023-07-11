package com.eInvoice.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;





@PropertySource("classpath:application.properties")
@Component
public class MyAuthentictionClass implements AuthenticationProvider {

	
	
	
	@Autowired
	private HttpSession session;
	
	@Value("${userId}")
	private String userName;
	
	@Value("${password}")
	private String password;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		System.out.println("username : "+username);
		System.out.println("password : "+pwd);
		System.out.println("username prop : "+userName);
		System.out.println("password prop : "+password);
		try {
			 if (userName.equalsIgnoreCase(username)  && password.equals(pwd)) {
				List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				return new UsernamePasswordAuthenticationToken(username, pwd, grantedAuths);
			}else {
				throw new BadCredentialsException("External system authentication failed");
			}
		} catch (Exception e) {
			throw new BadCredentialsException("External system authentication failed");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}


