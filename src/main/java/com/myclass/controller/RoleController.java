package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.constance.UrlConstance;
import com.myclass.entity.Role;
import com.myclass.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	RoleService roleService;

	@GetMapping(UrlConstance.ROLE_INDEX_URL)
	public String index(ModelMap map) {
		System.out.println("RoleIndex");

		map.addAttribute("roles", roleService.getAllObject("From roles"));

		return UrlConstance.ROLE_INDEX_MAPPING;
	}

	@GetMapping(UrlConstance.ROLE_ADD_URL)
	public String add(ModelMap map) {
		map.addAttribute("role", new Role());

		System.out.println("RoleAdd");
		return UrlConstance.ROLE_ADD_MAPPING;
	}
	
	@GetMapping(UrlConstance.ROLE_EDIT_URL + "/{id}")
	public String Edit(ModelMap map,
					@PathVariable("id") String roleId
					) {
		
		map.addAttribute("role", roleService.findByID(roleId));
		System.out.println("RoleEdit");
		
		return UrlConstance.ROLE_EDIT_MAPPING;
	}


	// Xóa role
	@GetMapping(UrlConstance.ROLE_DELETE_URL + "/{id}")
	public String delete(@PathVariable("id") String roleId) {
		roleService.DeleteById(roleId);
		return "redirect:" + UrlConstance.ROLE_INDEX_URL;
	}

	// Thêm 1 role mới
	@PostMapping(UrlConstance.ROLE_ADD_URL)
	public String add(ModelMap map, 
					@Validated @ModelAttribute("Role") Role role) {

		roleService.addNewObject(role);
		return "redirect:" + UrlConstance.ROLE_INDEX_URL;
	}
	
	@PostMapping(UrlConstance.ROLE_EDIT_URL + "/{id}" )
	public String Edit(ModelMap map, 
					@Validated @ModelAttribute("role") Role role,
					@PathVariable("id") String roleID
					) {
		System.out.println(roleID);
		roleService.update(role, roleID);
		return "redirect:" + UrlConstance.ROLE_INDEX_URL;
	}

}
