package com.mvc.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.vo.Plan;
import com.mvc.vo.PlanDetail;

@Mapper
public interface PlanMapper {
	// planitem 테이블에서 pid가 x인 전체 item 조회.
	ArrayList<PlanDetail> selectItem(int pid);
	
	// plan 테이블에서 uid가 x인 전체 plan 조회.
	
	ArrayList<Plan> selectPlanByUid(int uid);

	int insertPlanByUid(Plan p);

	int insertPlanDetail(PlanDetail pd);

}
