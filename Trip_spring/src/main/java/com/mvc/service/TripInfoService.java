package com.mvc.service;

import java.util.List;
import java.util.Map;

import com.mvc.vo.Gugun;
import com.mvc.vo.Sido;
import com.mvc.vo.TripInfo;


public interface TripInfoService {

	List<TripInfo> getInfoAll();

	List<TripInfo> searchContentTypeId(String contentTypeId);

	List<TripInfo> searchArea(int sidocode, int guguncode);

	List<TripInfo> searchTitle(String word);
	
	List<TripInfo> searchBySidoGugunTitle(Map<String, String> map);
	
	List<Sido> getSidoList();
	List<Gugun> getGugunList(String sidoCode);

	List<TripInfo> searchById(String id);
}
