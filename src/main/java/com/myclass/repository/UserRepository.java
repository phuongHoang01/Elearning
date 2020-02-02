package com.myclass.repository;

import java.util.List;

import com.myclass.dto.UserDTO;
import com.myclass.entity.User;



public interface UserRepository extends GenericsRepository<User, String>{
	public List<UserDTO> displayToTable();
	public User findByEmail(String email);
	public User findByID(String id);
	public boolean checkDuplicateResigter(String userEmail);
	public int updateUserByID(User user,String id);
}
