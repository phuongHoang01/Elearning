package com.myclass.service_imp;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.myclass.dto.ResigterDTO;
import com.myclass.dto.UserDTO;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
public class UserServiceImp extends GenericServiceImp<User, String> implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void addNewObject(User obj) {
		System.out.println(obj.getPassword());
		String hashString = BCrypt.hashpw(obj.getPassword(), BCrypt.gensalt(12));
		String id = UUID.randomUUID().toString();
		obj.setId(id);
		obj.setPassword(hashString);
		System.out.println(hashString);
		super.addNewObject(obj);
	}

	public void update(User obj, String userID) {
		obj.setId(userID);
		super.addNewObject(obj);
	}

	public List<UserDTO> displayToTable() {
		return userRepository.displayToTable();
	}

	public boolean ChangePasswordDto(com.myclass.dto.ChangePasswordDto entity) {
		try {
			String hashString = BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt(12));
			User user = userRepository.findByEmail(entity.getEmail());
			user.setPassword(hashString);
			super.addNewObject(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	public boolean resigter(User obj) {
		System.out.println(obj.getPassword());
		String hashString = BCrypt.hashpw(obj.getPassword(), BCrypt.gensalt(12));
		String id = UUID.randomUUID().toString();
		obj.setId(id);
		obj.setPassword(hashString);
		obj.setRoleID("78785529-a666-4357-a87e-191824438a8c");
		System.out.println(hashString);
		
		if(userRepository.checkDuplicateResigter(obj.getEmail())==true) {
			return true;
		}
		else {
			super.addNewObject(obj);
			return false;
		}
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByID(String id) {
		return userRepository.findByID(id);
	}
	
	public int updateUserByID(User user,String id) {
		return userRepository.updateUserByID(user, id);
	}


	
	
	
	


	
	
	

}
