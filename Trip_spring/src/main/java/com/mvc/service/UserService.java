package com.mvc.service;

import java.util.ArrayList;

import com.mvc.vo.User;

//Controller를 위한 인터페이스
public interface UserService {
	public ArrayList<User> selectAll();
	public ArrayList<User> selectOne(String id);
	public boolean checkUser(User u);
	public boolean DupCheck(String id);
	public int insert(User u);
	public int delete(String uid);
	public int update(User u);
}
