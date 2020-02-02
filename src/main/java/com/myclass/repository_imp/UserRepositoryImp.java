package com.myclass.repository_imp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import com.myclass.dto.UserDTO;

import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Repository
@Transactional(rollbackOn = Exception.class)
public class UserRepositoryImp extends GenericsRepositoryImp<User, String> implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public List<UserDTO> displayToTable() {
		// TODO Auto-generated method stub
		return null;
	}

//	public List<UserDTO> displayToTable() {
//		Session session = sessionFactory.getCurrentSession();
//		List<UserDTO> users = null;
//		String hql = "SELECT U.fullName,U.phone,U.email,R.description FROM users U,roles R WHERE U.roleID = R.id";
//		try {
//			Query<UserDTO> query = (Query<UserDTO>) session.createQuery(hql,UserDTO.class);
//			return users = query.getResultList();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	public User findByEmail(String email) {
		String hql = "FROM users WHERE email = :email";
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<User> query = session.createQuery(hql, User.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public User findByID(String email) {
		String hql = "FROM users WHERE id = :id";
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<User> query = session.createQuery(hql, User.class);
			query.setParameter("id", email);
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public boolean checkDuplicateResigter(String userEmail) {
		List<User> users = getAllObject("FROM users");
		for (User user : users) {
			if (user.getEmail() == userEmail) {
				return true;
			}
		}
		return false;

	}

	public int updateUserByID(User user,String id) {
		String hql = "Update users "
				+ "SET "
				+ "fullname =:fullName,"
				+ "email =:email,"
				+ "phone =:phone,"
				+ "address =:address,"
				+ "website =:website,"
				+ "facebook =:facebook "
				+ "Where id =:id";
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<User> query = session.createQuery(hql);
			query.setParameter("fullName", user.getFullName());
			query.setParameter("email", user.getEmail());
			query.setParameter("phone", user.getPhone());
			query.setParameter("address", user.getAddress());
			query.setParameter("website", user.getWebsite());
			query.setParameter("facebook", user.getFacebook());
			query.setParameter("id", id);
			return query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -2;
		}
	}

}
