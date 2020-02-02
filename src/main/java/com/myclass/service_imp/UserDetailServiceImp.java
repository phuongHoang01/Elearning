package com.myclass.service_imp;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myclass.dto.CustomUserDetail;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
@Service
public class UserDetailServiceImp implements UserDetailsService  {
	@Autowired
	UserRepository userRepository;

	public UserDetails loadUserByUsername(String email){
		User user = null;
		try {
			user = userRepository.findByEmail(email);
			
			
		} catch (Exception e) {
			System.out.println("Không tìm thấy tài khoảng");
			return null;
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		String roleNameString = user.getRole().getName();
		authorities.add(new SimpleGrantedAuthority(roleNameString));
		CustomUserDetail customUserDetail = new CustomUserDetail(user.getFullName(), user.getPassword(), authorities);
		customUserDetail.setId(user.getId());
		return customUserDetail;
	}

	
	
	
	
}
