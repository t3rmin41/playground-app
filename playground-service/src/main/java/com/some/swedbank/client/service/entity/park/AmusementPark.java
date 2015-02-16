package com.some.swedbank.client.service.entity.park;

import java.util.ArrayList;
import java.util.List;

import com.some.swedbank.client.service.entity.DomainEntity;
import com.some.swedbank.client.service.entity.playsite.PlaySite;

public class AmusementPark extends DomainEntity {

	private List<PlaySite> playSites;
	private Long visitorsTotal;
	
	public AmusementPark(Long id) {
		super(id);
		this.playSites = new ArrayList<PlaySite>();
	}
	
	public AmusementPark(Long id, List<PlaySite> list) {
		super(id);
		this.playSites = list;
	}

	public List<PlaySite> getPlaySites() {
		return playSites;
	}

	public void setPlaySites(List<PlaySite> playSites) {
		this.playSites = playSites;
	}

	public Long getVisitorsTotal() {
		return visitorsTotal;
	}

	public void setVisitorsTotal(Long visitorsTotal) {
		this.visitorsTotal = visitorsTotal;
	}
	 
}
