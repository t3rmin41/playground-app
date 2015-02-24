package com.some.client.dao.entity;


public class PlaySiteDao extends DaoEntity {

	private Long maximumKids;
	private String description;
	
	public PlaySiteDao(Long id) {
		super(id);
	}
	
	public PlaySiteDao(Long id, Long maximumKids) {
		super(id);
		this.maximumKids = maximumKids;
	}
	
	public PlaySiteDao(Long id, Long maximumKids, String description) {
		super(id);
		this.maximumKids = maximumKids;
		this.description = description;
	}

	public Long getMaximumKids() {
		return maximumKids;
	}

	public void setMaximumKids(Long maximumKids) {
		this.maximumKids = maximumKids;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
