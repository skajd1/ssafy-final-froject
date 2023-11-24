package com.mvc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.vo.AttractionLike;

@Mapper
public interface AttractionLikeMapper {	
	int selectLikeInfo(AttractionLike alike);
	int insertLike(AttractionLike alike);
	int deleteLike(AttractionLike alike);
	List<Map<Integer, Integer>> selectLikeCount();
}
