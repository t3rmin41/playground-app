package com.some.swedbank.client.service.entity.person;

import java.util.ArrayList;
import java.util.List;

import com.some.swedbank.client.service.entity.DomainEntity;
import com.some.swedbank.client.service.entity.playsite.PlaySiteSummary;

public class Kid extends DomainEntity {

	private String name;
	private Long age;
	private String ticketNumber;
	private Boolean waitingAccepted;
	
	private List<PlaySiteSummary> playSiteList;
	
	public Kid(Long id) {
		super(id);
	}
	
	public Kid(Long id, String name, Long age, String ticketNumber, Boolean waitingAccepted) {
		super(id);
		this.name = name;
		this.age = age;
		this.ticketNumber = ticketNumber;
		this.setWaitingAccepted(waitingAccepted);
		this.playSiteList = new ArrayList<PlaySiteSummary>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Boolean isWaitingAccepted() {
		return waitingAccepted;
	}
	
	public Boolean getWaitingAccepted() {
		return waitingAccepted;
	}

	public void setWaitingAccepted(Boolean waitingAccepted) {
		this.waitingAccepted = waitingAccepted;
	}

	public List<PlaySiteSummary> getPlaySiteList() {
		return playSiteList;
	}

	public void setPlaySiteList(List<PlaySiteSummary> playSiteList) {
		this.playSiteList = playSiteList;
	}
	
	public void addPlaySiteSummary(PlaySiteSummary playSiteSummary) {
		getPlaySiteList().add(playSiteSummary);
	}
	
}

