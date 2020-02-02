package com.myclass.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetail extends User   {
	public CustomUserDetail(String userName,String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(userName,password,authorities);
		// TODO Auto-generated constructor stub
	}
	
	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	
	
	
	
}
