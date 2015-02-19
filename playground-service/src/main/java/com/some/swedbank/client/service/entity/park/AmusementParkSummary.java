package com.some.swedbank.client.service.entity.park;

import java.util.Date;
import java.util.List;

import com.some.swedbank.client.service.entity.DomainEntity;
import com.some.swedbank.client.service.entity.playsite.PlaySiteSummary;

public class AmusementParkSummary extends DomainEntity  {

	private List<PlaySiteSummary> playSiteSummaries;
	private Long totalVisitors;
	private Date dateCreated;
	
	public AmusementParkSummary(Long id) {
		super(id);
		this.dateCreated = new Date();
	}
	
	public AmusementParkSummary(Long id, List<PlaySiteSummary> list, Long totalVisitors) {
		this(id);
		this.playSiteSummaries = list;
		this.totalVisitors = totalVisitors;
	}

	public List<PlaySiteSummary> getPlaySiteSummaries() {
		return playSiteSummaries;
	}

	public void setPlaySiteSummaries(List<PlaySiteSummary> playSiteSummaries) {
		this.playSiteSummaries = playSiteSummaries;
	}

	public Long getTotalVisitors() {
		return totalVisitors;
	}

	public void setTotalVisitors(Long totalVisitors) {
		this.totalVisitors = totalVisitors;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
