package com.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.AttractionLikeService;
import com.mvc.vo.AttractionLike;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "SSAFY")
@RequestMapping("/trip")
@CrossOrigin("*")
@RestController
public class AttractionLikeController {
	
	@Autowired
	AttractionLikeService service;

	@ApiOperation(value = "좋아요 체크",notes = "좋아요 여부 확인")
	@GetMapping("/attractionlike/{uid}/{content_id}")
	public boolean selectLikeInfo(@PathVariable int uid, @PathVariable int content_id) {
		AttractionLike alike = new AttractionLike(0, uid, content_id);	
		return service.selectLikeInfo(alike);
	}
	
	@ApiOperation(value = "좋아요 추가",notes = "해당 관광지 좋아요 추가")
	@PostMapping("/attractionlike")
	public int insertLike(@RequestBody AttractionLike alike) {
		return service.insertLike(alike);
	}
	
	@ApiOperation(value = "좋아요 취소",notes = "해당 관광지 좋아요 삭제")
	@PostMapping("/likecancel")
	public int deleteLike(@RequestBody AttractionLike alike) {
		return service.deleteLike(alike);
	}
	
	@GetMapping("/likecount")
	public Map<Integer, Integer> getLikeCount(){
		return service.getLikeCount();

	}
	
}
