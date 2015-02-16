package com.some.swedbank.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.some.swedbank.client.service.PlaySiteService;
import com.some.swedbank.client.service.entity.playsite.PlaySite;
import com.some.swedbank.client.service.mapper.PlaySiteDomainMapperWithDao;

@Service("playSiteService")
public class PlaySiteServiceImpl implements PlaySiteService {

	@Autowired
	private PlaySiteDomainMapperWithDao playSiteMapper;
	
	@Override
	public Long addNewPlaySite(PlaySite playSite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlaySite loadPlaySite(Long playSiteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePlaySite(PlaySite playSite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlaySiteById(Long playSiteId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PlaySite editPlaySite(PlaySite playSite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaySite> getAllPlaySites() {
		return playSiteMapper.getAllPlaySites();
	}

	@Override
	public Double getPlaySiteUtilization(PlaySite playSite) {
		return playSite.calculateUtilization();
	}

}
