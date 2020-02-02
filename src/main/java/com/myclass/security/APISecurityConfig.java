package com.myclass.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("com.myclass")
@Order(2)
public class APISecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	@Override
//	protected AuthenticationManager authenticationManager() throws Exception {
//		return super.authenticationManager();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//		.userDetailsService(userDetailsService)
//		.passwordEncoder(passwordEncoder());
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		System.out.println("run here");
//		http
//		.csrf().disable()
//		.antMatcher("/api/**")
//		.authorizeRequests()
//		.antMatchers("/api/Login**","/api/Register**")
//		.permitAll()
//		.anyRequest()
//		.authenticated();
//		
//		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), userDetailsService));
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	
//	}
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	// Khai báo service lấy thông tin user từ db và khai báo phương thức mã hóa password

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("OK hi you");
		http.cors();
		
//		// Cấu hình phân quyền
//		http
//		.csrf().disable()
//		.antMatcher("/api/**") // Gặp link này thì kiểm tra quyền
//		.authorizeRequests()
//		.antMatchers("/api/login", "/api/register")
//		.permitAll()
//		.anyRequest() // Những link còn lại phải yêu cầu đăng nhập trước
//		.authenticated();
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/login", "/api/register")	
		.permitAll()
		.antMatchers("/api/**")
		.hasAnyRole("ADMIN")
		.antMatchers("/manager/**")
		.hasAnyRole("ADMIN","MANAGER")
		.anyRequest()
		.authenticated();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	
	
}
