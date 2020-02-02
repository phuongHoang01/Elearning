package com.myclass.service_imp;

import org.springframework.stereotype.Service;

import com.myclass.entity.Course;
import com.myclass.entity.User;
import com.myclass.repository.CourseRepository;
import com.myclass.service.CourseService;
@Service
public class CourseServiceImp extends GenericServiceImp<Course, Integer> implements CourseService {
	public void update(Course obj,int courseID) {
		obj.setId(courseID);
		super.addNewObject(obj);
	}
}
