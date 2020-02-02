package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.constance.UrlConstance;

@Controller
public class AuthController {
	
//	@GetMapping(UrlConstance.LOGIN_URL)
//	public String Login() {
//		System.out.println("Login page");
//		return UrlConstance.LOGIN_MAPPING;
//	}
	
	@GetMapping(UrlConstance.LOGIN_URL)
	public String Login(@RequestParam(defaultValue = "") String error,ModelMap map) {
		if(!error.equals("")) {
			map.addAttribute("message", "Sai tên dăng nhập hoặc mật khẩu");
		}
		System.out.println("Login page");
		return UrlConstance.LOGIN_MAPPING;
	}
}
