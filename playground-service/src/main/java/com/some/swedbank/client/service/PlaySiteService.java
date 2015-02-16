package com.some.swedbank.client.service;

import java.util.List;

import com.some.swedbank.client.service.entity.playsite.PlaySite;

public interface PlaySiteService {

	Long addNewPlaySite(PlaySite playSite);
	
	PlaySite loadPlaySite(Long playSiteId);
	
	void deletePlaySite(PlaySite playSite);
	
	void deletePlaySiteById(Long playSiteId);
	
	PlaySite editPlaySite(PlaySite playSite);
	
	List<PlaySite> getAllPlaySites();
	
	Double getPlaySiteUtilization(PlaySite playSite);
}
