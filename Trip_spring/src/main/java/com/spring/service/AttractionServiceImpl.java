package com.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.AttractionMapper;
import com.spring.vo.AttractionDto;

@Service
public class AttractionServiceImpl implements AttractionService {

	@Autowired
	private AttractionMapper mapper;

	@Override
	public List<String> getGugunList(String sidoCode) {
		return mapper.getGugunList(sidoCode);
	}

	@Override
	public List<AttractionDto> searchByLocation(Map<String, String> map) {
		return mapper.searchByLocation(map);
	}

	@Override
	public List<AttractionDto> searchByContent(String content) {
		return mapper.searchByContent(content);
	}
}
