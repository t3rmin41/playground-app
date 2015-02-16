package com.some.swedbank.client.service;

import com.some.swedbank.client.service.entity.park.AmusementPark;

public interface AmusementParkService {
	
	AmusementPark loadById(Long parkId);
	
	Long addNewPlaySite(Long parkId, Long playSiteId);
	
	void deletePlaySite(Long parkId, Long playSiteId);
	
	void deleteAmusementPark(Long parkId);
}
