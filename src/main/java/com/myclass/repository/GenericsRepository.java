package com.myclass.repository;

import java.util.List;

public interface GenericsRepository<T, K> {
	public List<T> getAllObject(String query);
	public T findByID(K objId);
	public void DeleteById(K objId);
	public void addNewObject(T obj);
}
