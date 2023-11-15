package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.AttractionService;
import com.spring.vo.AttractionDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"관광정보를 보여주는 Controller"})
@RestController
@RequestMapping("/attraction")
public class AttractionController {
	
	@Autowired
	AttractionService service;
	
	@ApiImplicitParam(name="sidoCode", value="시/도 코드", required = true)
	@ApiOperation(value = "시/도에 해당하는 구/군 정보 반환하는 메소드")
	@GetMapping("/sido/{sido}")
	public List<String> getGugunList(@PathVariable String sidoCode){
		return service.getGugunList(sidoCode);
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="sido", value="시/도 코드", required = true),
		@ApiImplicitParam(name="gugun", value="구/군 코드", required = true)
	})
	@ApiOperation(value = "검색한 위치에 있는 관광 정보 반환하는 메소드")
	@GetMapping("/{sido}/{gugun}")
	public List<AttractionDto> searchByLocation(@PathVariable("sido") String sido, @PathVariable("gugun") String gugun){
		Map<String, String> map = new HashMap<String, String>();
		map.put("sido", sido);
		map.put("gugun", gugun);
		return service.searchByLocation(map);
	}
	
	@ApiImplicitParam(name="content", value="컨텐츠 코드", required = true)
	@ApiOperation(value = "컨텐츠 종류에 따른 관광 정보 반환하는 메소드")
	@GetMapping("/{content}")
	public List<AttractionDto> searchByContent(@PathVariable("content") String content){
		return service.searchByContent(content);
	}
}
