package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.myclass.constance.UrlConstance;
import com.myclass.entity.Role;
import com.myclass.entity.User;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	
	
	@GetMapping(UrlConstance.USER_HOME_URL)
	public String index(ModelMap map) {
		System.out.println("UserHome");
		
		map.addAttribute("users", userService.getAllObject("FROM users"));
		return UrlConstance.USER_HOME_MAPPING;
	}
	
	@GetMapping(UrlConstance.USER_ADD_URL)
	public String add(ModelMap map) {
		System.out.println("UserAdd");
		map.addAttribute("user", new User());
		map.addAttribute("roles",roleService.getAllObject("FROM roles"));
		return UrlConstance.USER_ADD_MAPPING;
	}
	
	@PostMapping(UrlConstance.USER_ADD_URL)
	public String add(ModelMap modelMap,
					@Validated @ModelAttribute("user") User user,
					BindingResult erroResult) {
		//Validation
		if(erroResult.hasErrors()) {
			modelMap.addAttribute("roles", roleService.getAllObject("FROM roles"));
			return UrlConstance.USER_ADD_MAPPING;
		}
		
		userService.addNewObject(user);
		return "redirect:"+ UrlConstance.USER_HOME_URL;
	}
	
	
	//
	@GetMapping(UrlConstance.USER_DELETE_URL+"{id}")
	public String delete(@PathVariable("id") String userId) {
		userService.DeleteById(userId);
		return "redirect:"+ UrlConstance.USER_HOME_URL;
	}
	
	
	@GetMapping(UrlConstance.USER_EDIT_URL +"{id}")
	public String update(ModelMap map,
						@PathVariable("id") String userID) {
		System.out.println("UserEdit");
		map.addAttribute("roles", roleService.getAllObject("FROM roles"));
		map.addAttribute("user", userService.findByID(userID));
		return UrlConstance.USER_EDIT_MAPPING;
	}
	
	@PostMapping(UrlConstance.USER_EDIT_URL +"{id}")
	public String update(ModelMap map,
						@Validated
						@PathVariable("id") String userID,
						@ModelAttribute("user") User user,
						BindingResult erroResult) {

		if(erroResult.hasErrors()) {
			System.out.println("hello there123");
			map.addAttribute("roles", roleService.getAllObject("FROM roles"));
			return UrlConstance.USER_EDIT_MAPPING;
		}
		System.out.println("hello there1234");
		userService.update(user, userID);
		return "redirect:"+ UrlConstance.USER_HOME_URL;
	}
	
	
	
	
	
	
	
	
	
	
}
