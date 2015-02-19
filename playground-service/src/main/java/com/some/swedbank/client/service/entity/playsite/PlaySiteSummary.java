package com.some.swedbank.client.service.entity.playsite;

import java.util.Date;

import com.some.swedbank.client.service.entity.DomainEntity;

public class PlaySiteSummary extends DomainEntity {

	private Long secondsTotal;
	private String description;
	private Double currentUtilization;
	private Date dateCreated;
	
	public PlaySiteSummary(Long id, Long secondsTotal) {
		super(id);
		this.setDateCreated(new Date());
		this.secondsTotal = secondsTotal;
	}
	
	public PlaySiteSummary(Long id, Long secondsTotal, String description) {
		this(id, secondsTotal);
		this.description = description;
	}
	
	public PlaySiteSummary(Long id, Long secondsTotal, String description, Double util) {
		this(id, secondsTotal, description);
		this.currentUtilization = util;
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

	public Double getCurrentUtilization() {
		return currentUtilization;
	}

	public void setUtilization(Double util) {
		this.currentUtilization = util;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "At "+ this.description + " total " + this.secondsTotal + " seconds";
	}
}
