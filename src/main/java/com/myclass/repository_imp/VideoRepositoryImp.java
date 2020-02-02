package com.myclass.repository_imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Video;
import com.myclass.repository.VideoRepository;
@Repository
public class VideoRepositoryImp extends GenericsRepositoryImp<Video, Integer> implements VideoRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Video> getVideoByCourseID(String courseID) {
		String hql = "FROM videos WHERE course_id = :courseID";
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Video> videosQuery = session.createQuery(hql,Video.class);
			videosQuery.setParameter("courseID", courseID);
			return videosQuery.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
