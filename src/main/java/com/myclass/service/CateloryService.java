package com.myclass.service;

import com.myclass.entity.Categories;

public interface CateloryService extends GenericsService<Categories, Integer> {
	public void update(Categories obj,int cateID);
}
