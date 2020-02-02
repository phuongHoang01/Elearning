package com.myclass.api_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.User;
import com.myclass.service.UserService;

@RestController
public class ApiUpdateInfo {
	@Autowired
	UserService userService;
	
	@PutMapping("api/user/updateUserInfo")
	public ResponseEntity changeUserInfo(@RequestBody User user,
										@RequestParam("id") String id) {
		try {
			System.out.println(userService.updateUserByID(user, id));
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
