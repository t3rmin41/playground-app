package com.some.client.dao.entity;

public class PlaySitesToAmusementParksDao extends DaoEntity {

	private Long playSiteId;
	private Long amusementParkId;
	
	public PlaySitesToAmusementParksDao(Long id) {
		super(id);
	}
	
	public PlaySitesToAmusementParksDao(Long id, Long playSiteId, Long amusementParkId) {
		super(id);
		this.playSiteId = playSiteId;
		this.amusementParkId = amusementParkId;
	}

	public Long getPlaySiteId() {
		return playSiteId;
	}

	public void setPlaySiteId(Long playSiteId) {
		this.playSiteId = playSiteId;
	}

	public Long getAmusementParkId() {
		return amusementParkId;
	}

	public void setAmusementParkId(Long amusementParkId) {
		this.amusementParkId = amusementParkId;
	}

}
