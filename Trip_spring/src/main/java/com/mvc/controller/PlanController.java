package com.mvc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.PlanService;
import com.mvc.vo.Plan;
import com.mvc.vo.PlanDetail;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "SSAFY")
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
	public String makePlan(@RequestBody Plan p) {
		
		int res = service.insertPlanByUid(p);
		if(res == 1) return "추가 완료";
		return "추가 실패 . . . ";
	}
	@PostMapping("/plandetails")
	public String insertDetail(@RequestBody PlanDetail pd) {
		int res = service.insertPlanDetail(pd);
		if(res == 1) return "추가 완료";
		return "추가 실패 . . . ";
	}

}
