package com.myclass.service;

import java.util.List;

import com.myclass.entity.Role;

public interface RoleService extends GenericsService<Role, String> {
	public void update(Role obj,String roleID);
}
