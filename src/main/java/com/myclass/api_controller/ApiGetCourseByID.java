package com.myclass.api_controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.Course;
import com.myclass.service.CourseService;

@RestController
public class ApiGetCourseByID {
	
	@Autowired
	CourseService courseService;
	
	
	@GetMapping("api/course/getCourseByID"+"/{id}")
	public 	ResponseEntity<Course> getCourseByID(@PathVariable("id") int courseID) {
		System.out.println(courseID);
		//int courseID = 9;
		try {
			Course course = courseService.findByID(courseID);
			return new ResponseEntity<Course>(course,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);   
		}
		
	}

}
