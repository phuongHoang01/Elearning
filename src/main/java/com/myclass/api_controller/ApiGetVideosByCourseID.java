package com.myclass.api_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.Video;
import com.myclass.service.VideoService;

@RestController
public class ApiGetVideosByCourseID {

	@Autowired
	VideoService videoService;
	
	@GetMapping("/api/video/getVideosByCourseID")
	public ResponseEntity<List<Video>> getVideos(@RequestParam("id") String courseID) {
		try {
			List<Video> videos = videoService.getVideoByCourseID(courseID);
			if(videos.isEmpty()) {
				return new ResponseEntity("Unavailable course",HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<List<Video>>(videos,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
	