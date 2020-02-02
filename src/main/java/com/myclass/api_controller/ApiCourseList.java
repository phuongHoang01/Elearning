package com.myclass.api_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.Course;
import com.myclass.service.CourseService;

@RestController
public class ApiCourseList {
	@Autowired
	CourseService courseService;
	
	@GetMapping("/api/course/getAllCourse")
	public ResponseEntity<List<Course>> courseList(){
		List<Course> courses;
		try {
			courses = courseService.getAllObject("FROM courses");
			return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Course>>(HttpStatus.BAD_REQUEST);
		}
	}

}
