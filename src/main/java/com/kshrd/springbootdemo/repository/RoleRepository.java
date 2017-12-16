package com.kshrd.springbootdemo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kshrd.springbootdemo.model.Role;

@Repository
public interface RoleRepository {

	@Select("select r.id, r.role from tbrole r")
	public List<Role> findRoles();
	
}
