package com.kshrd.springbootdemo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.kshrd.springbootdemo.model.User;

@Repository
public interface MybatisUserRepository {

	@Select("select id, name, gender, image from tbuser")
	public List<User> findAll();

	@Select("select id, name, gender, image from tbuser where id=#{id}")
	public User findById(Integer id);

	@Insert("insert into tbuser(id, name, gender, image) values(#{id}, #{name}, #{gender}, #{image})")
	public boolean save(User user);

	@Delete("delete from tbuser where id=#{id}")
	public boolean remove(Integer id);

	@Update("update tbuser set name=#{name}, gender=#{gender}, image=#{image} where id=#{id}")
	public boolean update(User user);
	
}
