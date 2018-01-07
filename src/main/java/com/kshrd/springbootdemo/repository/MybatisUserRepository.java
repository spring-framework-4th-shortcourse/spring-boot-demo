package com.kshrd.springbootdemo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.kshrd.springbootdemo.model.User;
import com.kshrd.springbootdemo.utility.Paging;

@Repository
public interface MybatisUserRepository {

	@Select("select id, name, gender, image from tbuser limit #{limit} offset #{offset}")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "name", column = "name"),
		@Result(property = "gender", column = "gender"),
		@Result(property = "image", column = "image"),
		@Result(property = "roles", column = "id", many = @Many(select = "com.kshrd.springbootdemo.repository.RoleRepository.findRolesByUserId"))
	})
	public List<User> findWithPagination(Paging paging);
	
	@Select("select count(*) from tbuser")
	public Integer countUser();
	
	@Select("select id, name, gender, image from tbuser where id=#{id}")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "roles", column = "id", many = @Many(select = "com.kshrd.springbootdemo.repository.RoleRepository.findRolesByUserId"))
	})
	public User findById(Integer id);

	@Insert("insert into tbuser(name, gender, image) values(#{name}, #{gender}, #{image})")
	@SelectKey(before = false, statement = "SELECT LAST_INSERT_ID()", keyColumn = "id", keyProperty = "id", resultType = Integer.class)
	public boolean save(User user);
	
	@Insert("insert into tbuser_role(user_id, role_id) values(#{user_id}, #{role_id})")
	public boolean saveUserRole(@Param("user_id") Integer userId, @Param("role_id") Integer roleId);
	
	@Delete("delete from tbuser where id=#{id}")
	public boolean remove(@Param("id") Integer id);

	@Update("update tbuser set name=#{name}, gender=#{gender}, image=#{image} where id=#{id}")
	public boolean update(User user);
	
	@Update("update tbuser_role set role_id=#{role_id} where user_id=#{user_id}")
	public boolean updateUserRoleByUserId(@Param("user_id") int userId, @Param("role_id") int roleId);
	
	@Delete("delete from tbuser_role where user_id=#{userId}")
	public boolean removeUserRoleByUserId(Integer userId);
	
}
