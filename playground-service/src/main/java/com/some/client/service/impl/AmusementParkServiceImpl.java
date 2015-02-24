package com.some.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.some.client.service.AmusementParkService;
import com.some.client.service.entity.park.AmusementPark;
import com.some.client.service.entity.park.AmusementParkSummary;
import com.some.client.service.entity.playsite.PlaySite;
import com.some.client.service.mapper.AmusementParkDomainMapperWithDao;
import com.some.client.service.mapper.PlaySiteDomainMapperWithDao;

@Service("amusementParkService")
public class AmusementParkServiceImpl implements AmusementParkService {

	@Autowired
	private AmusementParkDomainMapperWithDao amusementParkMapper;
	
	@Autowired
	private PlaySiteDomainMapperWithDao playSiteMapper;
	
	@Override
	public AmusementPark loadById(Long id) {
		return amusementParkMapper.getAmusementPark(id);
	}

	@Override
	public Long addNewPlaySite(Long parkId, Long playSiteId) {
		 PlaySite playSite = playSiteMapper.loadPlaySite(playSiteId);
		 return amusementParkMapper.addNewPlaySite(parkId, playSite);
	}

	@Override
	public void deletePlaySite(Long parkId, Long playSiteId) {
		amusementParkMapper.deletePlaySite(parkId, playSiteId);
	}

	@Override
	public void deleteAmusementPark(Long parkId) {
		amusementParkMapper.deleteAmusementPark(parkId);
	}

	@Override
	public List<AmusementPark> getAllAmusementParks() {
		return amusementParkMapper.getAllAmusementParks();
	}

	@Override
	public List<AmusementParkSummary> getAllSnapshots(AmusementPark park) {
		return park.getSnapshots();
	}
}
