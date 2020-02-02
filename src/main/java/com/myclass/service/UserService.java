package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserDTO;
import com.myclass.entity.User;

public interface UserService extends GenericsService<User, String> {
	public void addNewObject(User obj);
	public void update(User obj,String userID);
	public List<UserDTO> displayToTable();
	public boolean ChangePasswordDto(com.myclass.dto.ChangePasswordDto entity);
	public boolean resigter(User obj);
	public User findByEmail(String email);
	public int updateUserByID(User user,String id);
}
