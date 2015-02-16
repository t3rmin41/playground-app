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
import com.some.swedbank.client.service.entity.playsite.PlaySite;

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
		return new AmusementPark(
								 amusementParkDao.getId(),
								 playSiteMapper.getPlaySiteList(playSiteDaoList)
								);
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

}
