package com.some.client.service;

import java.util.List;

import com.some.client.service.entity.park.AmusementPark;
import com.some.client.service.entity.park.AmusementParkSummary;

public interface AmusementParkService {
	
	AmusementPark loadById(Long parkId);
	
	Long addNewPlaySite(Long parkId, Long playSiteId);
	
	void deletePlaySite(Long parkId, Long playSiteId);
	
	void deleteAmusementPark(Long parkId);
	
	List<AmusementPark> getAllAmusementParks();
	
	List<AmusementParkSummary> getAllSnapshots(AmusementPark park);
}
