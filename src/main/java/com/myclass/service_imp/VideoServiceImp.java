package com.myclass.service_imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Video;
import com.myclass.repository.VideoRepository;
import com.myclass.service.VideoService;
@Service
public class VideoServiceImp extends GenericServiceImp<Video, Integer> implements VideoService {
		
	
	@Autowired
	VideoRepository videoRepository;
	
	public void update(Video obj,int videoID) {
		obj.setId(videoID);
		super.addNewObject(obj);
	}

	public List<Video> getVideoByCourseID(String courseID) {
		return videoRepository.getVideoByCourseID(courseID);
	}
	
	
}
