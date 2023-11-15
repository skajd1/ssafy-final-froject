package com.spring.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;
import com.spring.vo.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mapper;

	@Override
	public boolean login(String id, String pw) {
		return mapper.checkIdPw(id,pw);
	}

	@Override
	public void regist(MemberDto member) {
		mapper.regist(member);
	}

	@Override
	public void delete(String id) {
		mapper.mdelete(id);
	}

	@Override
	public void update(MemberDto member) {
		mapper.mupdate(member);
	}

	@Override
	public ArrayList<MemberDto> getAllMembers() {
		ArrayList<MemberDto> list = mapper.selectAll();
		return list;
	}

	@Override
	public MemberDto getMember(String id) {
		MemberDto member =mapper.selectOne(id);
		return member;
	}

}
