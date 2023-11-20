package com.mvc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	int uid;
	String id;
	String pw;
	String nickname;
	int admin;
	String pimgsrc;
	
	public boolean isAdmin() {
		if (admin == 1) return true;
		return false;
	}
}
