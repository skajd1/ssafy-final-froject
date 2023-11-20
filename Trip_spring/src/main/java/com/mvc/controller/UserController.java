package com.mvc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SessionManager;
import com.mvc.service.UserService;
import com.mvc.vo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/trip")
@Api(value = "SSAFY")
public class UserController {
	
	
	
	private UserService us;
	
	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}
	@ApiOperation(value = "전체 유저 리스트",notes = "어드민전용으로 전체 유저 리스트 호출할 때 사용")
	@GetMapping(value = "/user")
	public ArrayList<User> getAllUser() {
		return us.selectAll();
	}
	@ApiOperation(value = "회원가입",notes = "User 객체를 파라미터로 받아서 회원가입 성공하면 '가입 성공' 메세지 반환 실패하면 '가입 실패'")
	@PostMapping(value = "/user")
	public boolean registUser(@RequestBody User u) {
		
		// id 중복 체크
		if(!us.DupCheck(u.getId())) return false;
		
		int res = us.insert(u);
		if(res==1) return true;
		return false;
	}
	@ApiOperation(value = "패스워드 변경",notes = "User 객체를 바디로 받아서 해당 아이디를 가진 유저의 비밀번호 변경. 성공/실패 유무 메세지 반환")
	@PutMapping(value = "/user")
	public String updateUser(@RequestBody User u) {
		int res = us.update(u);
		if(res==1) return "수정 성공";
		return "수정 실패";
	}
	
	@ApiOperation(value = "회원 탈퇴",notes = "파라미터로 uid를 넘겨서 해당 아이디의 유저 삭제. 삭제 성공/실패 유무 메세지 반환")
	@DeleteMapping(value = "/user/uid/{uid}")
	public String deleteUser(@PathVariable String uid) {
		int res = us.delete(uid);
		if(res==1) return "회원 삭제 성공";
		return "삭제 실패";
	}
	
	@ApiOperation(value = "로그인",notes = "아이디 비번 확인해서 체크되면 세션 등록, 해당 유저가 어드민이면 admin 세션을 1로 등록. 로그인 실패 시, 실패 메세지 반환")
	@PostMapping(value = "/user/login")
	public boolean login(@RequestBody User u) {
		boolean res = us.checkUser(u);
		return res;
		
	}
	

	
	

}
