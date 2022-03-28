package com.example.sprint1.service;

import java.util.List;
import com.example.sprint1.bean.RoleEntity;
import com.example.sprint1.dto.RoleOutputDto;

public interface IRoleService {
	
	String addRole(RoleEntity role);
	public RoleOutputDto addDto(RoleEntity role);
	RoleEntity deleteRole(RoleEntity role);
	RoleEntity deleteRoleById(long id);
	RoleEntity deleteRoleByName(String name);
	RoleEntity updateRole(RoleEntity role);
	RoleEntity updateRoleNameById(long id,String name);
	List<RoleEntity> getAllRoles();
	RoleEntity getRoleById(long id);
	RoleEntity getRoleByName(String name);
}
