package com.some.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.some.client.service.PlaySiteService;
import com.some.client.service.entity.playsite.PlaySite;
import com.some.client.service.mapper.PlaySiteDomainMapperWithDao;

@Service("playSiteService")
public class PlaySiteServiceImpl implements PlaySiteService {

	@Autowired
	private PlaySiteDomainMapperWithDao playSiteMapper;
	
	@Override
	public Long addNewPlaySite(PlaySite playSite) {
		return playSiteMapper.addNewPlaySite(playSite);
	}

	@Override
	public PlaySite loadPlaySite(Long playSiteId) {
		return playSiteMapper.loadPlaySite(playSiteId);
	}

	@Override
	public void deletePlaySite(PlaySite playSite) {
		playSiteMapper.deletePlaySite(playSite);
	}

	@Override
	public void deletePlaySiteById(Long playSiteId) {
		playSiteMapper.deletePlaySiteById(playSiteId);
	}

	@Override
	public PlaySite editPlaySite(PlaySite playSite) {
		return playSiteMapper.editPlaySite(playSite);
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
