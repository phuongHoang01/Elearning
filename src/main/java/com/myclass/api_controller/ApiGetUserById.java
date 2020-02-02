package com.myclass.api_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.User;
import com.myclass.service.UserService;

@RestController
public class ApiGetUserById {

	@Autowired
	UserService userService;
	
	@GetMapping("api/user/getUserByID")
	public ResponseEntity<User> getUserByID(@RequestParam("id") String id) {
		try {
			User user = userService.findByID(id);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
}
