package com.some.swedbank.client.dao.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.some.swedbank.client.dao.entity.AmusementParkDao;
import com.some.swedbank.client.dao.entity.PlaySiteDao;

@Repository
public class AmusementParkRepository {

	@Autowired
	private PlaySiteRepository playSiteRepository;
	
	public AmusementParkDao loadAmusementPark(Long parkId) {
		return new AmusementParkDao(parkId, loadAmusementParkPlaySites(parkId));
	}
	
	public List<PlaySiteDao> loadAmusementParkPlaySites(Long parkId) {
		// SELECT playsite_id FROM playsites_to_parks WHERE park_id = parkId
		String parkIdString = parkId.toString();
		List<Long> playsiteIds = null;
		switch (parkIdString) {
			case "1": playsiteIds = new ArrayList<Long>(Arrays.asList(1L,1L,4L,2L));
					  break;
			case "2": playsiteIds = new ArrayList<Long>(Arrays.asList(3L,1L,2L,4L));
					  break;
			case "3": playsiteIds = new ArrayList<Long>(Arrays.asList(2L,1L,2L,4L));
					  break;
			default : break;
		}
		
		List<PlaySiteDao> playsites =  new ArrayList<PlaySiteDao>();
		
		if (playsiteIds != null) {
			for(Long playSiteId : playsiteIds) {
				playsites.add(playSiteRepository.loadPlaySite(playSiteId));
			}
		}
		return playsites;
	}
	
	public Long addNewPlaySite(Long id, PlaySiteDao playSiteDao) {
		return playSiteDao.getId()+1L;
	}
	
	public void deletePlaySite(Long parkId, Long playSiteId) {
		 AmusementParkDao amusementParkDao = loadAmusementPark(parkId);
		 amusementParkDao.deletePlaySiteDaoById(playSiteId);
	}
	
	public void deleteAmusementPark(Long parkId) {
		
	}
	
	public List<AmusementParkDao> getAllAmusementParks() {
		List<AmusementParkDao> list = new ArrayList<AmusementParkDao>();
		for (int i = 1; i < 4; i++) {
			list.add(new AmusementParkDao((long) i));
		}
		return list;
	}
}
