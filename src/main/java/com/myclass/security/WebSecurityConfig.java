package com.myclass.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myclass.constance.UrlConstance;
@Configuration
@EnableWebSecurity
@ComponentScan("com.myclass")
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
					
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/Login**")	
		.permitAll()
		.antMatchers("/admin/**")
		.hasAnyRole("ADMIN")
		.antMatchers("/manager/**")
		.hasAnyRole("ADMIN","MANAGER")
		.anyRequest()
		.permitAll();
		
		http
		.formLogin()
		.loginProcessingUrl("/admin/Login")
		.loginPage(UrlConstance.LOGIN_URL)
		.usernameParameter("email")
		.passwordParameter("password")
		.defaultSuccessUrl("/default")
		.failureUrl("/Login?error=true");
		
		http.logout()
		.logoutUrl("/admin/Logout")
		.logoutSuccessUrl(UrlConstance.LOGIN_URL)
		.deleteCookies("JSESSIONID");
		
		http.exceptionHandling()
		.accessDeniedPage("/error/403");

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
}
