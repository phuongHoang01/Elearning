package com.myclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.internal.NotNull;
@Entity(name = "users")
public class User {
	@Id
	private String id;
	
	@Email(message = "Vui lòng nhập đúng định dạng email")
	private String email;
	
	
	@Length(message = "Vui lòng nhập đúng tên",min = 3,max = 50)
	@Column(name = "fullname")
	private String fullName;
	
	
	@NotEmpty(message = "Vui lòng nhập mật khẩu")
	@Column(name = "password")
	private String password; 
	
	private String avatar;
	private String phone;
	private String address;
	private String website;
	private String facebook;
	
	@NotBlank(message = "Vui lòng chọn loại người dùng")
	@Column(name = "role_id")
	private String roleID;
	
	@ManyToOne()
	@JoinColumn(name = "role_id",insertable = false,updatable = false)
	private Role role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	
	public User(String id, String email, String fullName, String password, String avatar, String phone, String address,
			String website, String facebook, String roleID) {
		super();
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.avatar = avatar;
		this.phone = phone;
		this.address = address;
		this.website = website;
		this.facebook = facebook;
		this.roleID = roleID;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
}
