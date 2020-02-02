package com.myclass.api_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.Categories;
import com.myclass.service.CateloryService;

@RestController
public class GetCateLists {
	@Autowired
	private CateloryService cateloryService;

	@GetMapping("api/catelory/getAllCate")
	public ResponseEntity<List<Categories>> getList(){
		List<Categories> categories = cateloryService.getAllObject("FROM categories");
		return new ResponseEntity<List<Categories>>(categories,HttpStatus.OK);
	}
}
