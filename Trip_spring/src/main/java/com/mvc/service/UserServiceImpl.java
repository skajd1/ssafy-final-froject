package com.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mapper.UserMapper;
import com.mvc.vo.TripInfo;
import com.mvc.vo.User;
@Service
public class UserServiceImpl implements UserService{
	
	private UserMapper mapper;
	@Autowired
	UserServiceImpl(UserMapper mapper){
		this.mapper = mapper;
	}
	@Override
	public ArrayList<User> selectAll() {
		return mapper.selectAll();
	}
	@Override
	public ArrayList<User> selectOne(String id) {
		return mapper.selectOne(id);
	}
	@Override
	public int insert(User u) {
		return mapper.insert(u);
	}
	@Override
	public int delete(String uid) {
		return mapper.delete(uid);
	}
	@Override
	public int update(User u) {
		return mapper.update(u);
	}
	@Override
	public boolean checkUser(User u) {
		User res = mapper.checkUser(u.getId(), u.getPw());
		if(res == null) return false;
		return true;
	}
	@Override
	public boolean DupCheck(String id) {
		ArrayList<User> res = mapper.selectOne(id);
		if(res.size() > 1) return false;
		return true;
	}
	


	

	

}






