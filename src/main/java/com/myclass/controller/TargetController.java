package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.myclass.constance.UrlConstance;

@Controller
public class TargetController {
	
	@GetMapping(UrlConstance.TARGET_INDEX_URL)
	public String index() {
		System.out.println("TargetIndex");
		return UrlConstance.TARGET_INDEX_MAPPING;
	}
	
	@GetMapping(UrlConstance.TARGET_ADD_URL)
	public String add() {
		System.out.println("TargetHome");
		return UrlConstance.TARGET_ADD_MAPPING;
	}
}
