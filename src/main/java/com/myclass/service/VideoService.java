package com.myclass.service;

import java.util.List;

import com.myclass.entity.Categories;
import com.myclass.entity.Video;

public interface VideoService extends GenericsService<Video, Integer> {
	public void update(Video obj,int videoID);
	public List<Video> getVideoByCourseID(String courseID);

}
