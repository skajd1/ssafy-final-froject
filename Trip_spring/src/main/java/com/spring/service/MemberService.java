package com.spring.service;

import java.util.ArrayList;

import com.spring.vo.MemberDto;

public interface MemberService {
	public boolean login(String id, String pw);
	public void regist(MemberDto member);
	public void delete(String id);
	public void update(MemberDto member);
	public ArrayList<MemberDto> getAllMembers();
	public MemberDto getMember(String id);
}
