package com.mvc.service;

import java.util.ArrayList;

import com.mvc.vo.Plan;
import com.mvc.vo.PlanDetail;

public interface PlanService {
	// planitem 테이블에서 pid가 x인 전체 item 조회.
		ArrayList<PlanDetail> selectItem(String pid);
		
		// plan 테이블에서 uid가 x인 전체 plan 조회.
		
		ArrayList<Plan> selectPlanByUid(String uid);

		int insertPlanByUid(Plan p);

		int insertPlanDetail(PlanDetail pd);

}
