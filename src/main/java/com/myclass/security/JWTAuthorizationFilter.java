package com.myclass.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	
	@Autowired
	private UserDetailsService _userDetailsService;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager,UserDetailsService userDetailsService) {
		super(authenticationManager);
		this._userDetailsService = userDetailsService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final String jWT_KEY = "abcdef";
		String tokenBearer = request.getHeader("Authorization");
		System.out.println(tokenBearer);
		if(tokenBearer != null && tokenBearer.startsWith("Bearer ")) {
			 String token = tokenBearer.replace("Bearer ", "");
			 String email = Jwts.parser()
					 	.setSigningKey(jWT_KEY)
					 	.parseClaimsJws(token)
					 	.getBody()
					 	.getSubject();
			UserDetails userDetails = _userDetailsService.loadUserByUsername(email);
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		System.out.println("fuck you if you run here");
		chain.doFilter(request, response);
		
	}
	
	

//	private UserDetailsService userDetailsService;
//
//	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, UserDetailsService _userDetailsService) {
//		super(authenticationManager);
//		System.out.println("JWT");
//		this.userDetailsService = _userDetailsService;
//	}
//	
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		// TODO Auto-generated method stub
//				System.out.println("jwt run here");
//				String headerAuthorization = request.getHeader("Authorization");
//				System.out.println("check" + headerAuthorization);
//
//				if (headerAuthorization != null && headerAuthorization.startsWith("Bearer ")) {
//					System.out.println("run here pls");
//					String token = headerAuthorization.replace("Bearer ", "");
//					System.out.println(token);
//					String email = Jwts.parser().setSigningKey("abcdef").parseClaimsJws(token).getBody().getSubject();
//					UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//
//					Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,
//							userDetails.getAuthorities());
//					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//				}
//				chain.doFilter(request, response);
//	}
}
