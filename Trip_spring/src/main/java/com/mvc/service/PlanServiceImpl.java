package com.mvc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mapper.PlanMapper;
import com.mvc.vo.Plan;
import com.mvc.vo.PlanDetail;

@Service
public class PlanServiceImpl implements PlanService{
	
	private PlanMapper mapper;
	@Autowired
	PlanServiceImpl(PlanMapper mapper){
		this.mapper = mapper;
		
	}

	@Override
	public ArrayList<PlanDetail> selectItem(String pid) {
		return mapper.selectItem(Integer.parseInt(pid));
	}

	@Override
	public ArrayList<Plan> selectPlanByUid(String uid) {
		return mapper.selectPlanByUid(Integer.parseInt(uid));
	}

	@Override
	public int insertPlanByUid(Plan p) {
		
		return mapper.insertPlanByUid(p);
	}

	@Override
	public int insertPlanDetail(PlanDetail pd) {
		return mapper.insertPlanDetail(pd);
	}

}
