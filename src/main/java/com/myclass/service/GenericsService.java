package com.myclass.service;

import java.util.List;

import com.myclass.entity.Role;

public interface GenericsService<T,K> {
	public void addNewObject(T obj);
	public List<T> getAllObject(String query);
	public T findByID(K objId);
	public void DeleteById(K roleId);
}
