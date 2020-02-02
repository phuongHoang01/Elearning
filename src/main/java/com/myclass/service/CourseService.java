package com.myclass.service;

import com.myclass.entity.Course;

public interface CourseService extends  GenericsService<Course, Integer> {
	public void update(Course obj,int courseID);
}
