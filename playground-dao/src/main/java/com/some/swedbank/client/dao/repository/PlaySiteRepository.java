package com.some.swedbank.client.dao.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.some.swedbank.client.dao.entity.PlaySiteDao;

@Repository
public class PlaySiteRepository {

	public Long addNewPlaySite(PlaySiteDao playSiteDao) {
		return playSiteDao.getId()+1L;
	}
	
	public void deletePlaySite(PlaySiteDao playSiteDao) {
		
	}
	
	public void deletePlaySiteById(Long id) {
		
	}
	
	public PlaySiteDao editPlaySite(PlaySiteDao playSite) {
		return new PlaySiteDao(playSite.getId(), playSite.getMaximumKids(), playSite.getDescription());
	}
	
	
	public PlaySiteDao loadPlaySite(Long playSiteId) {
		// SELECT id, description, maximum_kids FROM playsites WHERE :id = playSiteId;
		switch (playSiteId.toString()) {
			case "1": return new PlaySiteDao(playSiteId, 2L, "DoubleSwing");
			case "2": return new PlaySiteDao(playSiteId, 5L, "Carousel");
			case "3": return new PlaySiteDao(playSiteId, 1L, "Slide");
			case "4": return new PlaySiteDao(playSiteId, 4L, "BallPit");
			default:  return null;
		}
	}
	
	public List<PlaySiteDao> getAllPlaySites() {
		List<PlaySiteDao> list = new ArrayList<PlaySiteDao>();
		
		list.add(new PlaySiteDao(1L, 2L, "DoubleSwing"));
		list.add(new PlaySiteDao(2L, 5L, "Carousel"));
		list.add(new PlaySiteDao(3L, 1L, "Slide"));
		list.add(new PlaySiteDao(4L, 4L, "BallPit"));
		
		return list;
	}
}
