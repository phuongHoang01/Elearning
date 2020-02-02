package com.myclass.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;



@Entity(name = "categories")
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Tiều đề vui lòng không bỏ trống")
	private String title;
	private String icon;
	@Column(name = "order_index")
	private int orderIndex;
	
	@OneToMany(mappedBy = "categories",fetch = FetchType.LAZY)
	private List<Course> courses;

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}
	
	public Categories() {
		// TODO Auto-generated constructor stub
	}

	public Categories(int id, String title, String icon, int orderIndex) {
		super();
		this.id = id;
		this.title = title;
		this.icon = icon;
		this.orderIndex = orderIndex;
	}
	
	
}
