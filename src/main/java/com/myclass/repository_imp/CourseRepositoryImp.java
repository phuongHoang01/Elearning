package com.myclass.repository_imp;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Course;
import com.myclass.repository.CourseRepository;
@Repository
public class CourseRepositoryImp 
					extends GenericsRepositoryImp<Course, Integer> 
					implements CourseRepository{
	

}
