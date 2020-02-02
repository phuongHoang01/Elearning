package com.myclass.api_controller;

import java.util.Date;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.ChangePasswordDto;
import com.myclass.dto.CustomUserDetail;
import com.myclass.dto.UserLogin;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javafx.scene.chart.PieChart.Data;
@RestController
public class ApiLoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	@PostMapping("api/Login")
	public ResponseEntity<String> login(@RequestBody UserLogin userLogin ){
		
		Authentication authenticationToken = 
		new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword());
		try {
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();
			Date now = new Date();
			
			String token  = Jwts.builder()
					.setSubject(userDetails.getId())
					.setIssuedAt(now) // Thời điểm phát hành
					.setExpiration(new Date(now.getTime() + 864000000L)) // Thời gian tồn tại của token
					.signWith(SignatureAlgorithm.HS512, "abcdef")
					.compact();
			
			return new ResponseEntity<String>(token,HttpStatus.OK);
		} catch (Exception e) {
				e.printStackTrace();
		}
		return new ResponseEntity<String>("Sai tên đăng nhập hoặc mật khẩu", HttpStatus.BAD_REQUEST);
		
	
	}
	
	public String generateToken (Authentication authentication,UserDetails userDetails) {
		final String JWT_SECRET = "key";
		final long JWT_EXPIRATION = 864000000L;
		
		Date now = new Date();
		Date expiryDate = new Date(now.getTime()+JWT_EXPIRATION);
		
		String token = Jwts.builder()
				.setSubject(userDetails.getUsername())
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, "key")
				.compact();
		return token;
	}
	
}
