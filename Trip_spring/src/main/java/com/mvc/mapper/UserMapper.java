package com.mvc.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.vo.User;

@Mapper
public interface UserMapper {
	public ArrayList<User> selectAll();
	public ArrayList<User> selectOne(String id);
	public int insert(User u);
	public int delete(String uid);
	public int update(User u);
	public User checkUser(String id, String pw);
}
