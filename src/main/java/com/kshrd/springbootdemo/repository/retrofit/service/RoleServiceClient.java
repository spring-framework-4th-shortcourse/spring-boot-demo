package com.kshrd.springbootdemo.repository.retrofit.service;

import java.util.List;

import com.kshrd.springbootdemo.model.Role;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RoleServiceClient {
	
	@GET("/api/roles")
	Call<List<Role>> getAllRoles();
	
	@GET("/api/roles/{id}")
	Call<Role> getRoleById(@Path("id") Integer id);
	
}
