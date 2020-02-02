package com.myclass.service_imp;

import java.util.List;
import java.util.UUID;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;
@Service
public class RoleServiceImp extends GenericServiceImp<Role, String>  implements RoleService{
	
	@Override
	public void addNewObject(Role obj) {
		String id = UUID.randomUUID().toString();
		obj.setId(id);
		super.addNewObject(obj);
	}
	
	
	public void update(Role obj,String roleID) {
		obj.setId(roleID);
		super.addNewObject(obj);
	}
	

}
	
	 

