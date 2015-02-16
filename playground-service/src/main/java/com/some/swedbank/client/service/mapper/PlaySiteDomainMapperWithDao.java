package com.some.swedbank.client.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.some.swedbank.client.dao.entity.DaoEntity;
import com.some.swedbank.client.dao.entity.PlaySiteDao;
import com.some.swedbank.client.dao.repository.PlaySiteRepository;
import com.some.swedbank.client.service.entity.DomainEntity;
import com.some.swedbank.client.service.entity.playsite.BallPit;
import com.some.swedbank.client.service.entity.playsite.Carousel;
import com.some.swedbank.client.service.entity.playsite.DoubleSwings;
import com.some.swedbank.client.service.entity.playsite.PlaySite;
import com.some.swedbank.client.service.entity.playsite.Slide;

@Service("playSiteMapper")
public class PlaySiteDomainMapperWithDao implements DomainMapperWithDao {

	@Autowired
	private PlaySiteRepository playSiteRepository;
	
	private PlaySiteDao createDaoFromDomainPlaySite(PlaySite playSite) {
		return new PlaySiteDao(	
				  			   playSite.getId(),
				  			   playSite.getMaximumKids(),
				  			   playSite.getDescription()
				  			  );
	}

	@Override
	public DomainEntity createDomainFromDao(DaoEntity dao) {
		return loadPlaySite(dao.getId());
	}
	
	public PlaySite loadPlaySite(Long id) {
		PlaySiteDao playSiteDao = playSiteRepository.loadPlaySite(id);
		String playSiteId = playSiteDao.getId().toString();
		
		switch (playSiteId) {
			case "1": return new DoubleSwings(
											  playSiteDao.getId(),
											  playSiteDao.getMaximumKids(),
											  playSiteDao.getDescription()
											  );
			case "2": return new Carousel(
										  playSiteDao.getId(),
										  playSiteDao.getMaximumKids(),
										  playSiteDao.getDescription()
										 ); 
			case "3": return new Slide(
									   playSiteDao.getId(),
									   playSiteDao.getMaximumKids(),
									   playSiteDao.getDescription()
									  );
			case "4": return new BallPit(
										 playSiteDao.getId(),
										 playSiteDao.getMaximumKids(),
										 playSiteDao.getDescription()
										 );
			default: return null;
		}
	}
	
	public List<PlaySite> getPlaySiteList(List<PlaySiteDao> list) {
		List<PlaySite> playSiteList = new ArrayList<PlaySite>();
		for (PlaySiteDao playSiteDao : list) {
			playSiteList.add(loadPlaySite(playSiteDao.getId()));
		}
		return playSiteList;
	}
	
	public List<PlaySite> getAllPlaySites() {
		return getPlaySiteList(playSiteRepository.getAllPlaySites());
	}
	
	public Long addNewPlaySite(PlaySite playSite) {
		return playSiteRepository.addNewPlaySite(createDaoFromDomainPlaySite(playSite));
	}
	
	public void deletePlaySite(PlaySite playSite) {
		playSiteRepository.deletePlaySite(createDaoFromDomainPlaySite(playSite));
	}
	
	public void deletePlaySiteById(Long id) {
		playSiteRepository.deletePlaySiteById(id);
	}
	
	public PlaySite editPlaySite(PlaySite playSite) {
		return (PlaySite) createDomainFromDao(playSiteRepository.editPlaySite(createDaoFromDomainPlaySite(playSite)));
	}
	
}
