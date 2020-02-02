package com.myclass.api_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.Role;
import com.myclass.service.RoleService;

@RestController
public class GetRoleList {
	@Autowired
	private RoleService roleService;
	
	@GetMapping("api/role/getAllRole")
	public ResponseEntity<List<Role>> get(){
		List<Role> list = roleService.getAllObject("From roles");
		return new ResponseEntity<List<Role>>(list, HttpStatus.OK);
	}
}
