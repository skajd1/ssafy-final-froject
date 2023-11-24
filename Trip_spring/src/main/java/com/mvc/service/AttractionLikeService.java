package com.mvc.service;

import java.util.Map;

import com.mvc.vo.AttractionLike;

public interface AttractionLikeService {	
	boolean selectLikeInfo(AttractionLike alike);
	int insertLike(AttractionLike alike);
	int deleteLike(AttractionLike alike);
	Map<Integer, Integer> getLikeCount();
}
