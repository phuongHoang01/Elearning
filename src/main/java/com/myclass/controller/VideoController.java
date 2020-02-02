package com.myclass.controller;

import javax.validation.Valid;

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
import com.myclass.entity.Video;
import com.myclass.service.CourseService;
import com.myclass.service.VideoService;

@Controller
public class VideoController {
	
	@Autowired
	VideoService videoService;
	@Autowired
	CourseService CourseService;

	@GetMapping(UrlConstance.VIDEO_INDEX_URL)
	public String index(ModelMap map) {
		System.out.println("VideoIndex");
		map.addAttribute("videos", videoService.getAllObject("FROM videos"));
		return UrlConstance.VIDEO_INDEX_MAPPING;
	}
	
	@GetMapping(UrlConstance.VIDEO_ADD_URL)
	public String add(ModelMap map) {
		System.out.println("VideoAdd");
		map.addAttribute("courses", CourseService.getAllObject("FROM courses"));
		map.addAttribute("video", new Video());
		return UrlConstance.VIDEO_ADD_MAPPING;
	}
	
	@PostMapping(UrlConstance.VIDEO_ADD_URL)
	public String add(ModelMap map,
			@Valid
			@ModelAttribute("video") Video video,
			BindingResult error) {
		if(error.hasErrors()) {
			map.addAttribute("courses", CourseService.getAllObject("FROM courses"));
			return UrlConstance.VIDEO_ADD_MAPPING;
		}
		videoService.addNewObject(video);
		return "redirect:" + UrlConstance.VIDEO_INDEX_URL;
	}
	
	@GetMapping(UrlConstance.VIDEO_DELETE_URL+"/{id}")
	public String Delete(ModelMap map,@PathVariable("id") int videoID) {
		videoService.DeleteById(videoID);
		return "redirect:" + UrlConstance.VIDEO_INDEX_URL;
	}
		
	@GetMapping(UrlConstance.VIDEO_EDIT_URL + "/{id}")
	public String update(ModelMap map,
						@PathVariable("id") int videoID) {
		System.out.println("VideoEDIT");
		map.addAttribute("video", videoService.findByID(videoID));
		map.addAttribute("courses", CourseService.getAllObject("FROM courses"));
		return UrlConstance.VIDEO_EDIT_MAPPING;
	}
	
	@PostMapping(UrlConstance.VIDEO_EDIT_URL + "/{id}" )
	public String update(ModelMap map, 
					@Validated @ModelAttribute("video") Video video,
					@PathVariable("id") int videoID,
					BindingResult errorResult
					) {
		
		if(errorResult.hasErrors()) {
			return UrlConstance.CATELORY_EDIT_MAPPING;
		}
		System.out.println("--------------------------------------------"+videoID);
		videoService.update(video, videoID);
		return "redirect:" + UrlConstance.VIDEO_INDEX_URL;
	}

	
}
