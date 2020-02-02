package com.myclass.api_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.service.UserService;

@RestController
public class ChangePassword {
	
	@Autowired
	UserService userService;
	
	@PutMapping("api/user/changepassword")
	public ResponseEntity changePasswordDto(@RequestBody com.myclass.dto.ChangePasswordDto entity) {
		System.out.println(entity.getEmail()+"email here");
		System.out.println(entity.getPassword());
		try {
			if (userService.ChangePasswordDto(entity)) {
				return new ResponseEntity(HttpStatus.OK);
			}
			else {
				return new ResponseEntity(HttpStatus.BAD_GATEWAY);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_GATEWAY);
		}
		
	}
	
}
