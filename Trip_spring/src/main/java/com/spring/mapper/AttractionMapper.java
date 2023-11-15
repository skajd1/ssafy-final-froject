package com.spring.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.spring.vo.AttractionDto;

@Mapper
public interface AttractionMapper {

	List<String> getGugunList(String sidoCode);

	List<AttractionDto> searchByLocation(Map<String, String> map);

	List<AttractionDto> searchByContent(String content);

}
