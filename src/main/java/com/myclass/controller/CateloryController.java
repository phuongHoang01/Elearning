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
import org.springframework.web.bind.annotation.RequestMapping;
import com.myclass.constance.UrlConstance;
import com.myclass.entity.Role;
import com.myclass.service.CateloryService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.myclass.entity.Categories;


@Controller
public class CateloryController {
	
	@Autowired
	CateloryService cateloryService;
	
	@GetMapping(UrlConstance.CATELORY_HOME_URL)
	public String index(ModelMap map) {
		System.out.println("cateloryIndex");
		map.addAttribute("catelory", cateloryService.getAllObject("From categories"));
		return UrlConstance.CATELORY_HOME_MAPPING;
	}
	
	@GetMapping(UrlConstance.CATELORY_ADD_URL)
	public String add(ModelMap map) {
		System.out.println("CateloryAdd");
		map.addAttribute("categories", new Categories());
		return UrlConstance.CATELORY_ADD_MAPPING;
	}
	
	// Thêm 1 role mới
		@PostMapping(UrlConstance.CATELORY_ADD_URL)
		public String add(ModelMap map,
				@Validated 
				@ModelAttribute("categories") Categories categories
				,BindingResult errorResult) 
		{
			if(errorResult.hasErrors()) {
				return UrlConstance.CATELORY_ADD_MAPPING;
			}
			cateloryService.addNewObject(categories);
			return "redirect:" + UrlConstance.CATELORY_HOME_URL;
		}

		// Xóa role
		@GetMapping(UrlConstance.CATELORY_DELETE_URL + "/{id}")
		public String delete(@Validated @PathVariable("id") int cateloryId) {
			cateloryService.DeleteById(cateloryId);
			return "redirect:" + UrlConstance.CATELORY_HOME_URL;
		}
		
		
		@GetMapping(UrlConstance.CATELORY_EDIT_URL + "/{id}")
		public String update(ModelMap map,
							@PathVariable("id") int categoriesID) {
			System.out.println("CateloryAdd");
			map.addAttribute("categories", cateloryService.findByID(categoriesID));
			return UrlConstance.CATELORY_EDIT_MAPPING;
		}
		
		@PostMapping(UrlConstance.CATELORY_EDIT_URL + "/{id}" )
		public String update(ModelMap map, 
						@Validated @ModelAttribute("categories") Categories categories,
						@PathVariable("id") int cateID,
						BindingResult errorResult
						) {
			
			if(errorResult.hasErrors()) {
				return UrlConstance.CATELORY_EDIT_MAPPING;
			}
			System.out.println("--------------------------------------------"+cateID);
			cateloryService.update(categories, cateID);
			return "redirect:" + UrlConstance.CATELORY_HOME_URL;
		}
		
}
