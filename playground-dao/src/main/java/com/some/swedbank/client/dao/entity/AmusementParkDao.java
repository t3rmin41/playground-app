package com.some.swedbank.client.dao.entity;

import java.util.Iterator;
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
	
	public void deletePlaySiteDao(PlaySiteDao playSiteDao) {
		if (this.playSitesDao.contains(playSiteDao)) {
			this.playSitesDao.remove(playSiteDao);
		}
	}
	
	public void deletePlaySiteDaoById(Long playSiteId) {
		for (Iterator<PlaySiteDao> daoIter = playSitesDao.listIterator(); daoIter.hasNext(); ) {
			if (daoIter.next().getId().equals(playSiteId)) {
				daoIter.remove();
			}
		}
	}
	
}
