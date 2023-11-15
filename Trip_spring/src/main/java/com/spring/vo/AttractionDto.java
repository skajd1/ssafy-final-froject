package com.spring.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class AttractionDto {
	
	@NonNull
	@ApiModelProperty(value = "컨텐츠 식별자", required = true)
	int contentId;
	
	@NonNull
	@ApiModelProperty(value = "제목", required = true)
	String title;
	
	@NonNull
	@ApiModelProperty(value = "주소", required = true)
	String addr1;
	
	@NonNull
	@ApiModelProperty(value = "우편번호", required = true)
	String zipcode;
	String tel;
	
	@NonNull
	@ApiModelProperty(value = "이미지 주소", required = true)
	String firstImage;
	int readCount;
	int sidoCode;
	int gugunCode;
	Double latitude;
	Double longitude;
	
	String cat1;
	String cat2;
	String cat3;
	
	@NonNull
	@ApiModelProperty(value = "설명", required = true)
	String overview;
}
