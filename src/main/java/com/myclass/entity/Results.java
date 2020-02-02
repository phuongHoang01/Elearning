package com.myclass.entity;

public class Results {
	private int id;
	private String titleString;
	private int orderIndex;
	private int courseID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitleString() {
		return titleString;
	}

	public void setTitleString(String titleString) {
		this.titleString = titleString;
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

	public Results(int id, String titleString, int orderIndex, int courseID) {
		super();
		this.id = id;
		this.titleString = titleString;
		this.orderIndex = orderIndex;
		this.courseID = courseID;
	}

	public Results() {
		// TODO Auto-generated constructor stub
	}
}
