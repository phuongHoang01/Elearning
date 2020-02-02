
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
import com.myclass.entity.Categories;
import com.myclass.entity.Course;
import com.myclass.service.CateloryService;
import com.myclass.service.CourseService;


@Controller
public class CourseController {

	@Autowired
	CourseService courseService;
	@Autowired
	CateloryService cateloryService;

	@GetMapping(UrlConstance.COUSER_INDEX_URL)
	public String index(ModelMap map) {
		System.out.println("CourseIndex");
		map.addAttribute("courses", courseService.getAllObject("FROM courses"));
		return UrlConstance.COUSER_INDEX_MAPPING;
	}

	@GetMapping(UrlConstance.COUSER_ADD_URL)
	public String add(ModelMap map) {
		System.out.println("CourseAdd");
		map.addAttribute("categoriesList", cateloryService.getAllObject("FROM categories"));
		map.addAttribute("courses", new Course());
		return UrlConstance.COUSER_ADD_MAPPING;
	}
	
	
	@PostMapping(UrlConstance.COUSER_ADD_URL)
	public String add(ModelMap map,
					@Validated 
					@ModelAttribute("courses") Course course,
					BindingResult result) {
		if(result.hasErrors()) {
			map.addAttribute("categoriesList", cateloryService.getAllObject("FROM categories"));
			return UrlConstance.COUSER_ADD_MAPPING;
		}
			
		System.out.println("CourseAdd");
		courseService.addNewObject(course);
		return "redirect:"+ UrlConstance.COUSER_INDEX_URL;
	}
	
	@GetMapping(UrlConstance.COUSER_DELETE_URL + "/{id}")
	public String delete(@PathVariable("id") int courseID) {
		courseService.DeleteById(courseID);
		return "redirect:"+ UrlConstance.COUSER_INDEX_URL;
	}
	
	@GetMapping(UrlConstance.COUSER_EDIT_URL + "/{id}")
	public String update(ModelMap map,
						@PathVariable("id") int courseID) {
		System.out.println("CourseEdit");
		map.addAttribute("categoriesList", cateloryService.getAllObject("FROM categories"));
		map.addAttribute("courses",courseService.findByID(courseID));
	
		return UrlConstance.COUSER_EDIT_MAPPING;
	}
	
	@PostMapping(UrlConstance.COUSER_EDIT_URL + "/{id}" )
	public String update(ModelMap map, 
					@Validated @ModelAttribute("courses") Course course,
					@PathVariable("id") int courseID,
					BindingResult errorResult
					) {
		
		if(errorResult.hasErrors()) {
			return UrlConstance.COUSER_EDIT_MAPPING;
		}
		System.out.println("--------------------------------------------"+courseID);
		courseService.update(course, courseID);
		return "redirect:" + UrlConstance.COUSER_INDEX_URL;
	}
	
	
	
	
}
