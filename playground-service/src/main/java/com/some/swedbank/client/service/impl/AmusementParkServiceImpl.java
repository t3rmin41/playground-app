package com.some.swedbank.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.some.swedbank.client.service.AmusementParkService;
import com.some.swedbank.client.service.entity.park.AmusementPark;
import com.some.swedbank.client.service.mapper.AmusementParkDomainMapperWithDao;

@Service("amusementParkService")
public class AmusementParkServiceImpl implements AmusementParkService {

	@Autowired
	private AmusementParkDomainMapperWithDao amusementParkMapper;
	
	@Override
	public AmusementPark loadById(Long id) {
		return amusementParkMapper.getAmusementPark(id);
	}

	@Override
	public Long addNewPlaySite(Long parkId, Long playSiteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePlaySite(Long parkId, Long playSiteId) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAmusementPark(Long parkId) {
		// TODO Auto-generated method stub
	}

}
