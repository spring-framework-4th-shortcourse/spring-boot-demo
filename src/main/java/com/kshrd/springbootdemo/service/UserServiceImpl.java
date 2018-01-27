package com.kshrd.springbootdemo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.repository.retrofit.response.ResponseList;
import com.kshrd.springbootdemo.repository.retrofit.response.ResponseSingle;
import com.kshrd.springbootdemo.repository.retrofit.service.UserServiceClient;
import com.kshrd.springbootdemo.utility.Paging;

import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class UserServiceImpl implements UserService {
	
	private UserServiceClient userServiceClient; 

	@Autowired
	public UserServiceImpl(Retrofit retrofit) {
		this.userServiceClient = retrofit.create(UserServiceClient.class);
	}
	
	@Override
	public User searchById(Integer id) {
		Response<ResponseSingle<User>> jsonUser = null;
		try {
			jsonUser = this.userServiceClient.getUserById(id).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		User user = jsonUser.body().getData();
		return user;
	}
	
	@Transactional
	@Override
	public boolean createUser(User user) {
		Response<com.kshrd.springbootdemo.repository.retrofit.response.Response> response = null;
		try {
			response = this.userServiceClient.createUser(user).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response.isSuccessful();
	}

	@Override
	public boolean removeUser(Integer id) {
		Response<com.kshrd.springbootdemo.repository.retrofit.response.Response> response = null;
		try {
			response = this.userServiceClient.removeUser(id).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response.isSuccessful();
	}

	@Transactional
	@Override
	public boolean updateUser(User user) {
		Response<com.kshrd.springbootdemo.repository.retrofit.response.Response> response = null;
		try {
			response = this.userServiceClient.updateUser(user).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response.isSuccessful();
	}

	@Override
	public List<User> findWithPagination(Paging paging) {
		Response<ResponseList<List<User>>> jsonUsers = null;
		try {
			jsonUsers = userServiceClient.getAllUsers(paging.getPage(), paging.getLimit()).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ResponseList<List<User>> responseList = jsonUsers.body();
		paging.setTotalCount(responseList.getPaging().getTotalCount());
		
		return responseList.getData();
	}

}
