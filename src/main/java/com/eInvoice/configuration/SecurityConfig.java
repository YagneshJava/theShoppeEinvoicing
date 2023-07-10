package com.eInvoice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	
	@Autowired
	SessionRegistry sessionRegistry;
	
	@Autowired
	MyAuthenticationFailureHandler myAuthenticationFailureHandler;

	@Autowired
	CustomSuccessHandler customSuccessHandler;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/app-assets/**");
	}

	
	@Override
	public void configure(HttpSecurity http) throws Exception {
			
					http
					.authorizeRequests().antMatchers("/").access("permitAll")
					.and().formLogin().loginPage("/login")
					.successHandler(customSuccessHandler).failureHandler(myAuthenticationFailureHandler).usernameParameter("username")
					.passwordParameter("password").permitAll().and().logout().invalidateHttpSession(true)
					.logoutUrl("/logout").deleteCookies("JSESSIONID")
					.and().csrf().disable().exceptionHandling()
					.accessDeniedPage("/Access_Denied");
					
					http.sessionManagement().sessionAuthenticationErrorUrl("/sessionIn").maximumSessions(5)
					.maxSessionsPreventsLogin(true).expiredUrl("/sessionIn").sessionRegistry(sessionRegistry).and()
					.sessionFixation().newSession();
			

	}

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticator());
	}

	@Bean
	public AuthenticationProvider authenticator() throws Exception {
		return new MyAuthentictionClass();
	}

	


}
