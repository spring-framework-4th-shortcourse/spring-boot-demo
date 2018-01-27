package com.kshrd.springbootdemo.repository.retrofit.service;

import java.util.List;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.repository.retrofit.response.Response;
import com.kshrd.springbootdemo.repository.retrofit.response.ResponseList;
import com.kshrd.springbootdemo.repository.retrofit.response.ResponseSingle;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserServiceClient {

	@GET("/api/users")
	Call<ResponseList<List<User>>> getAllUsers(@Query("page") Integer page, @Query("limit") Integer limit);
	
	@GET("/api/users/{id}")
	Call<ResponseSingle<User>> getUserById(@Path("id") Integer id);
	
	@POST("/api/users")
	Call<Response> createUser(@Body User user);
	
	@DELETE("/api/users/{id}")
	Call<Response> removeUser(@Path("id") Integer id);
	
	@PUT("/api/users")
	Call<Response> updateUser(@Body User user);
	
	
}
