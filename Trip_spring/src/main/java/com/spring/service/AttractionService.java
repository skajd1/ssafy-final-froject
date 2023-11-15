package com.spring.service;

import java.util.List;
import java.util.Map;

import com.spring.vo.AttractionDto;

public interface AttractionService {
	
	public List<String> getGugunList(String sidoCode);

	public List<AttractionDto> searchByLocation(Map<String, String> map);

	public List<AttractionDto> searchByContent(String content);
	
}
