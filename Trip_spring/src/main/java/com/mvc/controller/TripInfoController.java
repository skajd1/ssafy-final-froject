package com.mvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.TripInfoService;
import com.mvc.vo.Gugun;
import com.mvc.vo.Sido;
import com.mvc.vo.TripInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin("*")
@RequestMapping("/trip")
@Api(value="SSAFY")
public class TripInfoController {
	@Autowired
	TripInfoService service;
	
	@ApiOperation(value = "시/도 반환하는 메소드")
	@GetMapping("/sido")
	public List<Sido> getSidoList(){
        return service.getSidoList();
    }
	
    @ApiOperation(value = "시/도에 해당하는 구/군 정보 반환하는 메소드")
    @GetMapping("/sido/{sido}")
    public List<Gugun> getGugunList(@PathVariable("sido") String sidoCode){
    	System.out.println(sidoCode);
        return service.getGugunList(sidoCode);
    }
    
    @ApiOperation(value = "시/도 및 구/군 및 여행 테마로 필터링 된 여행지 반환")
    @PostMapping("/list")
    public List<TripInfo> searchBySidoGugunTitle(@RequestBody Map<String, String> map){
    	return service.searchBySidoGugunTitle(map);
    }
    
	
	@ApiOperation(value="전체 관광지 리스트",notes="모든 여행지 정보를 반환한다")
	@GetMapping("/all")
	public List<TripInfo> getInfoAll(){
		
		return service.getInfoAll();
	}
	
	@ApiOperation(value="컨텐트 타입 별 관광지 리스트",notes="컨텐트 타입 별 관광지 정보를 반환한다")
	@GetMapping("/contentTypeId/{contentTypeId}")
	public List<TripInfo> searchContentId(@PathVariable("contentTypeId") String contentTypeId){
		
		return service.searchContentTypeId(contentTypeId);
	}
	
	@ApiOperation(value="지역 코드 별 관광지 리스트",notes="지역 코드 별 관광지 정보를 반환한다")
	@GetMapping("/area/{sidocode}/{guguncode}")
	public List<TripInfo> searchArea(@PathVariable("sidocode") String sidocode, @PathVariable("guguncode") String guguncode){
		return service.searchArea(Integer.parseInt(sidocode),Integer.parseInt(guguncode));
	}
	
	@ApiOperation(value="관광지명 별 관광지 리스트",notes="관광지명으로 검색한 관광지 정보를 반환한다 ")
	@GetMapping("/title/{word}")
	public List<TripInfo> searchTitle(@PathVariable("word") String word){
		return service.searchTitle(word);
	}
	
	@ApiOperation(value="content_id 로 관광지 조회",notes="해당 관광지 정보 출력")
	@GetMapping("/list/{content_id}")
	public List<TripInfo> searchById(@PathVariable("content_id") String id){
		return service.searchById(id);
	}
	@GetMapping(value = "/likelist/{uid}")
	public List<TripInfo> getLikeList(@PathVariable String uid){
		return service.getLikeList(uid);
	}
}
