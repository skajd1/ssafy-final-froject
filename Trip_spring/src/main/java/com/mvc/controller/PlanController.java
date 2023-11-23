package com.mvc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.PlanService;
import com.mvc.vo.Plan;
import com.mvc.vo.PlanDetail;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "SSAFY")
@CrossOrigin("*")
@RestController
public class PlanController {
	@Autowired
	PlanService service;
	
	@ApiOperation(value = "계획 세부 사항 조회",notes = "Item중 pid를 가진 모든 item 조회")
	@GetMapping("/plandetails/{pid}")
	public ArrayList<PlanDetail> getPlanDetail(@PathVariable String pid) {
		return service.selectItem(pid);
	}
	@ApiOperation(value = "유저 일정 조회",notes = "특정 유저가 작성한 모든 Plan 조회")
	@GetMapping("/plan/{uid}")
	public ArrayList<Plan> getPlanByUId(@PathVariable String uid) {
		return service.selectPlanByUid(uid);
	}

	
	@ApiOperation(value = "일정 테이블 생성",notes = "유저 아이디를 포함한 일정 테이블 생성")
	@PostMapping("/plan")
	public int makePlan(@RequestBody Plan p) {
		return service.insertPlanByUid(p);
		
	}
	@ApiOperation(value = "일정 테이블 삭제",notes = "테이블을 삭제하고 해당 pid를 갖고있는 모든 여행지도 삭제")
	@DeleteMapping("/plan/{pid}")
	public int deletePlan(@PathVariable String pid) {
		return service.deletePlanByPid(pid);
	}
	@ApiOperation(value = "일정 테이블에 여행지 추가",notes = "여행지 정보를 파라미터로 하여 일정에 여행지 및 코멘트, 예산 등의 정보 삽입")
	@PostMapping("/plandetails/{pid}")
	public String insertDetail(@RequestBody PlanDetail pd, @PathVariable String pid) {
		int res = service.insertPlanDetail(pd,pid);
		if(res == 1) return "추가 완료";
		return "추가 실패 . . . ";
	}

}
