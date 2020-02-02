package com.myclass.repository_imp;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.repository.GenericsRepository;


@Repository
@Transactional(rollbackOn = Exception.class)
public abstract class GenericsRepositoryImp<T, K extends Serializable> implements GenericsRepository<T, K> {

	@Autowired
	protected SessionFactory sessionFactory;

	
	private Class<? extends T> clazz;
	
	
	public GenericsRepositoryImp() {
		Type type = getClass().getGenericSuperclass() ;
		ParameterizedType pt = (ParameterizedType) type; 
		clazz = (Class) pt.getActualTypeArguments()[0];
	}

	public void receiveClass(Class<? extends T> clazz) {
		
	}
	public List<T> getAllObject(String query02) {

		Session session = sessionFactory.getCurrentSession();

		List<T> obj = null;

		try {
			Query<T> query = (Query<T>) session.createQuery(query02, clazz);
			return obj = query.getResultList();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Tìm role theo id
	public T findByID(K objId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.find(clazz, objId);
		} catch (HibernateException e) {
			// TODO: handle exception
		}
		return null;
	}

	// Xóa role theo id

	public void DeleteById(K objId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.remove(findByID(objId));
		} catch (HibernateException e) {
			// TODO: handle exception
		}
	}

	public void addNewObject(T obj) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.saveOrUpdate(obj);

		} catch (HibernateException e) {
			e.printStackTrace();

		}
	}
	
	
}
