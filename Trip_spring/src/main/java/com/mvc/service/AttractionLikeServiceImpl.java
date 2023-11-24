package com.mvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mapper.AttractionLikeMapper;
import com.mvc.vo.AttractionLike;

@Service
public class AttractionLikeServiceImpl implements AttractionLikeService{

	@Autowired
	private AttractionLikeMapper mapper;
	
	@Override
	public boolean selectLikeInfo(AttractionLike alike) {
		if(mapper.selectLikeInfo(alike) > 0) return true;
		return false;
	}

	@Override
	public int insertLike(AttractionLike alike) {
		return mapper.insertLike(alike);
	}

	@Override
	public int deleteLike(AttractionLike alike) {
		return mapper.deleteLike(alike);
	}

	@Override
	public Map<Integer, Integer> getLikeCount() {
		List<Map<Integer, Integer>> likelist = mapper.selectLikeCount();
		Map<Integer,Integer> map = new HashMap<>();
		for (Map<Integer,Integer> item : likelist) {
			int id = item.get("content_id");
			int cnt = Integer.parseInt(String.valueOf(item.get("cnt")));
			map.put(id, (int)cnt);			
		}
		return map;
	}
	
}
