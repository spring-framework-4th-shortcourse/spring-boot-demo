package com.kshrd.springbootdemo.repository;

import java.util.List;

import com.kshrd.springbootdemo.model.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.kshrd.springbootdemo.model.User;

@Repository
public interface MybatisUserRepository {

	@Select("select id, name, gender, image from tbuser")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "gender", column = "gender"),
			@Result(property = "roles", column = "id", many = @Many(select = "findRoleByUserId"))
	})
	public List<User> findAll();

	@Select("select r.id, r.role from tbuser_role ur inner join tbrole r on r.id=ur.role_id where ur.user_id =#{id}")
	public List<Role> findRoleByUserId(int id);

	@Select("select id, name, gender, image from tbuser where id=#{id}")
	public User findById(Integer id);

	@Insert("insert into tbuser(id, name, gender, image) values(#{id}, #{name}, #{gender}, #{image})")
	@SelectKey(keyProperty = "id", keyColumn = "id", before = true, statement = "SELECT LAST_INSERT_ID()",  resultType = Integer.class)
	public boolean save(User user);

	@Delete("delete from tbuser where id=#{id}")
	public boolean remove(Integer id);

	@Update("update tbuser set name=#{name}, gender=#{gender}, image=#{image} where id=#{id}")
	public boolean update(User user);



}
