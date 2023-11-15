package com.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String jdate;
}