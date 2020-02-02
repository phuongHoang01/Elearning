package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Video;

public interface VideoRepository extends GenericsRepository<Video, Integer>{
	public List<Video> getVideoByCourseID(String courseID);
}



