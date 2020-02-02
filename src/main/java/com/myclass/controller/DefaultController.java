package com.myclass.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.myclass.constance.UrlConstance;
@Controller
public class DefaultController {
	
    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
    	
        if (request.isUserInRole("ROLE_ADMIN") || request.isUserInRole("ROLE_MANAGER")) {
        	return "redirect:" + UrlConstance.CATELORY_HOME_URL;
        }
        return "redirect:" +"http://127.0.0.1:5500/index.html";
    }
}
