package com.some.swedbank.client.service.entity.playsite;

import com.some.swedbank.client.service.entity.DomainEntity;

public class PlaySiteSummary extends DomainEntity {

	private Long secondsTotal;
	private String description;
	
	public PlaySiteSummary(Long id, Long secondsTotal) {
		super(id);
		this.secondsTotal = secondsTotal;
	}
	
	public PlaySiteSummary(Long id, Long secondsTotal, String description) {
		super(id);
		this.secondsTotal = secondsTotal;
		this.description = description;
	}

	public Long getSecondsTotal() {
		return secondsTotal;
	}

	public void setSecondsTotal(Long secondsTotal) {
		this.secondsTotal = secondsTotal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "At "+ this.description + " total " + this.secondsTotal + " seconds";
	}
}
