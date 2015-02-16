package com.some.swedbank.client.service.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.some.swedbank.client.dao.entity.AmusementParkDao;
import com.some.swedbank.client.dao.entity.DaoEntity;
import com.some.swedbank.client.dao.entity.PlaySiteDao;
import com.some.swedbank.client.dao.repository.AmusementParkRepository;
import com.some.swedbank.client.service.entity.DomainEntity;
import com.some.swedbank.client.service.entity.park.AmusementPark;

@Service("amusementParkMapper")
public class AmusementParkDomainMapperWithDao implements DomainMapperWithDao {

	@Autowired
	private AmusementParkRepository amusementParkRepository;
	
	@Autowired 
	private PlaySiteDomainMapperWithDao playSiteMapper;

	@Override
	public DomainEntity createDomainFromDao(DaoEntity dao) {
		return null;
	}
	
	public AmusementPark getAmusementPark(Long id) {
		AmusementParkDao amusementParkDao = amusementParkRepository.loadAmusementPark(id);
		List<PlaySiteDao> playSiteDaoList = amusementParkRepository.loadAmusementParkPlaySites(id);
		return new AmusementPark(
								 amusementParkDao.getId(),
								 playSiteMapper.getPlaySiteList(playSiteDaoList)
								);
	}

}
