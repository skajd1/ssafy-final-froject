package com.mvc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class PlanDetail {
	private int piid;
	private int cost;
	private String date;
	private String comment;
	private int pid;
	private int content_id;

}
