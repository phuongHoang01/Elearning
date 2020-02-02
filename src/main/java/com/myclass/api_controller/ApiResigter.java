package com.myclass.api_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.ResigterDTO;
import com.myclass.entity.User;
import com.myclass.service.UserService;

@RestController
public class ApiResigter {
	@Autowired
	UserService userService;
	
	@PostMapping("api/user/resigter")
	public ResponseEntity resigter(@RequestBody User entity) {
		try {
			if(userService.resigter(entity) == true) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
