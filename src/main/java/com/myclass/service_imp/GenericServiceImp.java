package com.myclass.service_imp;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.myclass.repository.GenericsRepository;
import com.myclass.repository_imp.GenericsRepositoryImp;
import com.myclass.service.GenericsService;

@Service
@ComponentScan(basePackages = "com.myclass")
public abstract class GenericServiceImp<T,K> implements GenericsService<T, K> {
	
	
	@Autowired
	protected GenericsRepository<T, K> genericsRepository;
	
	
	
	public void addNewObject(T obj) {
		genericsRepository.addNewObject(obj);
		
	}

	public List<T> getAllObject(String query) {
		return genericsRepository.getAllObject(query);
	}

	public void DeleteById(K objId) {
		genericsRepository.DeleteById(objId);
		
	}
	
	public T findByID(K objId) {
		try {
			return genericsRepository.findByID(objId);
		} catch (NullPointerException e) {
			return null;
		}
	}
	
}
