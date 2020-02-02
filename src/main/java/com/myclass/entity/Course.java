package com.myclass.entity;

import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String image;
	
	@NotNull()
	@Column(name = "letures_count")
	private int leturesCount;
	
	@Column(name = "hour_count")
	private int hourCount;
	
	@Column(name = "view_count")
	private int viewCount;
	
	@NotNull
	private int price;
	private int discount;
	
	
	@Column(name = "promotion_price")
	private int promotionPrice;
	
	
	@NotEmpty(message = "Vui lòng nhập mô tả")
	private String description;
	
	@NotNull
	@NotEmpty(message = "Vui lòng nhập nội dung khóa học")
	private String content;
	
	@Column(name = "category_id")
	private int cateloryID;
	
	@ManyToOne
	@JoinColumn(name = "category_id",insertable = false,updatable = false)
	private Categories categories;
	
	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
	private List<Video> videos;
	
	@Column(name = "last_update")
	private Time lastUpdate;
	
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getLeturesCount() {
		return leturesCount;
	}
	public void setLeturesCount(int leturesCount) {
		this.leturesCount = leturesCount;
	}
	public int getHourCount() {
		return hourCount;
	}
	public void setHourCount(int hourCount) {
		this.hourCount = hourCount;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(int promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCateloryID() {
		return cateloryID;
	}
	public void setCateloryID(int cateloryID) {
		this.cateloryID = cateloryID;
	}
	public Time getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Time lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(int id, String title, String image, int leturesCount, int hourCount, int viewCount, int price,
			int discount, int promotionPrice, String description, String content, int cateloryID, Time lastUpdate) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.leturesCount = leturesCount;
		this.hourCount = hourCount;
		this.viewCount = viewCount;
		this.price = price;
		this.discount = discount;
		this.promotionPrice = promotionPrice;
		this.description = description;
		this.content = content;
		this.cateloryID = cateloryID;
		this.lastUpdate = lastUpdate;
	}
}
