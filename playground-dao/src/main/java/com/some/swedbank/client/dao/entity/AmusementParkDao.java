package com.some.swedbank.client.dao.entity;

import java.util.List;


public class AmusementParkDao extends DaoEntity {

	private List<PlaySiteDao> playSitesDao;
	
	public AmusementParkDao(Long id) {
		super(id);
	}
	
	public AmusementParkDao(Long id, List<PlaySiteDao> playSitesDao) {
		super(id);
		this.playSitesDao = playSitesDao;
	}

	public List<PlaySiteDao> getPlaySitesDao() {
		return playSitesDao;
	}

	public void setPlaySitesDao(List<PlaySiteDao> playSitesDao) {
		this.playSitesDao = playSitesDao;
	}
	
}
