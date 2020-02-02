package com.myclass.service_imp;

import org.springframework.stereotype.Service;

import com.myclass.entity.Categories;
import com.myclass.entity.Role;
import com.myclass.service.CateloryService;
@Service
public class CateloryServiceImpl extends GenericServiceImp<Categories, Integer> implements CateloryService {
	
	public void update(Categories obj,int cateID) {
		obj.setId(cateID);
		super.addNewObject(obj);
	}
}
