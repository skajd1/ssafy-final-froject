package com.spring.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.spring.vo.MemberDto;

@Mapper
public interface MemberMapper {
	public ArrayList<MemberDto> selectAll();
	public MemberDto selectOne(String id);
	public boolean checkIdPw(String id, String pw);
	public boolean idDupCheck(String id);
	public boolean minsert(MemberDto member);
	public void regist(MemberDto member);
	public void mupdate(MemberDto member);
	public void mdelete(String id);
}
