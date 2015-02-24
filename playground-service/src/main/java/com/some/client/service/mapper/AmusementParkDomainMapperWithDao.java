package com.some.client.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.some.client.dao.entity.AmusementParkDao;
import com.some.client.dao.entity.DaoEntity;
import com.some.client.dao.entity.PlaySiteDao;
import com.some.client.dao.repository.AmusementParkRepository;
import com.some.client.service.entity.DomainEntity;
import com.some.client.service.entity.park.AmusementPark;
import com.some.client.service.entity.playsite.PlaySite;

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
	
	private PlaySiteDao createPlaySiteDaoFromDomain(PlaySite playSite) {
		return new PlaySiteDao(	
	  			   playSite.getId(),
	  			   playSite.getMaximumKids(),
	  			   playSite.getDescription()
	  			  );
	}
	
	public AmusementPark getAmusementPark(Long id) {
		AmusementParkDao amusementParkDao = amusementParkRepository.loadAmusementPark(id);
		List<PlaySiteDao> playSiteDaoList = amusementParkRepository.loadAmusementParkPlaySites(id);
		/*
		AmusementPark park = new AmusementPark(
				 amusementParkDao.getId(),
				 playSiteMapper.getPlaySiteList(playSiteDaoList)
				);
		park.makeSnapshot();
		return park;
		/**/
		return new AmusementPark(
								 amusementParkDao.getId(),
								 playSiteMapper.getPlaySiteList(playSiteDaoList)
								);
		/**/
	}
	
	public Long addNewPlaySite(Long id, PlaySite playSite) {
		return amusementParkRepository.addNewPlaySite(id, createPlaySiteDaoFromDomain(playSite));
	}
	
	public void deletePlaySite(Long parkId, Long playSiteId) {
		amusementParkRepository.deletePlaySite(parkId, playSiteId);
	}
	
	public void deleteAmusementPark(Long id) {
		amusementParkRepository.deleteAmusementPark(id);
	}
	
	public List<AmusementPark> getAllAmusementParks() {
		List<AmusementPark> listDomain = new ArrayList<AmusementPark>();
		List<AmusementParkDao> listDao = new ArrayList<AmusementParkDao>();
		listDao = amusementParkRepository.getAllAmusementParks();
		for (AmusementParkDao dao : listDao) {
			listDomain.add(getAmusementPark(dao.getId()));
		}
		return listDomain;
	}

}
