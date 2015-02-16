package com.some.swedbank.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.some.swedbank.client.service.KidService;
import com.some.swedbank.client.service.entity.person.Kid;
import com.some.swedbank.client.service.mapper.KidDomainMapperWithDao;

@Service("kidService")
public class KidServiceImpl implements KidService {

	@Autowired
	private KidDomainMapperWithDao kidMapper;
	
	@Override
	public List<Kid> getAllKids() {
		return kidMapper.getAllKids();
	}

}
