package com.myclass.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity(name = "videos")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Vui lòng nhập tiêu đề")
	private String title;
	@NotEmpty(message = "Vui lòng nhập dường dẫn")
	private String url;
	
	@NotNull
	@Column(name = "time_count")
	private int timeCount;
	
	@Column(name = "order_index")
	private int orderIndex;
	
	@NotNull
	@Column(name = "course_id")
	private int courseID;
	
	@ManyToOne()
	@JoinColumn(name = "course_id",insertable = false,updatable = false)
	private Course course;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTimeCount() {
		return timeCount;
	}

	public void setTimeCount(int timeCount) {
		this.timeCount = timeCount;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	

	public Video(int id, String title, String url, int timeCount, int orderIndex, int courseID) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.timeCount = timeCount;
		this.orderIndex = orderIndex;
		this.courseID = courseID;
		
	}
	
	public Video() {
		// TODO Auto-generated constructor stub
	}

}
