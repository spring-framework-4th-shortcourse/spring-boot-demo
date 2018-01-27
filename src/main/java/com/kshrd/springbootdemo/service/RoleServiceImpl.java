package com.kshrd.springbootdemo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.springbootdemo.model.Role;
import com.kshrd.springbootdemo.repository.retrofit.service.RoleServiceClient;

import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class RoleServiceImpl implements RoleService{

	private RoleServiceClient roleServiceClient;
	
	@Autowired
	public RoleServiceImpl(Retrofit retrofit) {
		this.roleServiceClient = retrofit.create(RoleServiceClient.class);
	}
	
	@Override
	public List<Role> getAllRoles() {
		Response<List<Role>> jsonRoles = null;
		try {
			jsonRoles = this.roleServiceClient.getAllRoles().execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Role> roles = jsonRoles.body();
		return roles;
	}

	@Override
	public Role getRoleById(Integer id) {
		Response<Role> jsonRole = null;
		try {
			jsonRole = this.roleServiceClient.getRoleById(id).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Role role = jsonRole.body();
		return role;
	}

}
