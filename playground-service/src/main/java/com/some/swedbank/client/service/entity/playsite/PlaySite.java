package com.some.swedbank.client.service.entity.playsite;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.some.swedbank.client.service.entity.DomainEntity;
import com.some.swedbank.client.service.entity.person.Kid;
import com.some.swedbank.client.service.entity.person.KidSummary;
import com.some.swedbank.client.service.exception.PlaySiteIsEmptyException;
import com.some.swedbank.client.service.exception.WaitingIsNotAcceptedException;
import com.some.swedbank.client.service.exception.WaitingListIsEmptyException;

public abstract class PlaySite extends DomainEntity {

	private Long maximumKids;
	private String description;
	private Long lastKidsUsed = 5L;
	
	private List<Kid> kidsCurrentlyUsing;
	private List<Kid> waitingKids;
	private List<KidSummary> usageHistory;

	private Date dateStarted;
	private Date dateFinished;
	private Long secondsTotal;
	
	public PlaySite(Long id) {
		super(id);
		kidsCurrentlyUsing = new ArrayList<Kid>();
		waitingKids = new ArrayList<Kid>();
		usageHistory = new ArrayList<KidSummary>();
	}
	
	public PlaySite(Long id, Long maximumKids) {
		this(id);
		this.maximumKids = maximumKids;
	}
	
	public PlaySite(Long id, Long maximumKids, String description) {
		this(id);
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

	public Long getLastKidsUsed() {
		return lastKidsUsed;
	}

	public void setLastKidsUsed(Long lastKidUsed) {
		this.lastKidsUsed = lastKidUsed;
	}

	public List<Kid> getKidsCurrentlyUsing() {
		return kidsCurrentlyUsing;
	}

	public void setKidsCurrentlyUsing(List<Kid> kidsCurrentlyUsing) {
		this.kidsCurrentlyUsing = kidsCurrentlyUsing;
	}
	
	public List<Kid> getWaitingKids() {
		return waitingKids;
	}

	public void setWaitingKids(List<Kid> waitingKids) {
		this.waitingKids = waitingKids;
	}
	
	public List<KidSummary> getUsageHistory() {
		return usageHistory;
	}

	public void setUsageHistory(List<KidSummary> usageHistory) {
		this.usageHistory = usageHistory;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Date getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(Date dateFinished) {
		this.dateFinished = dateFinished;
	}

	public Long getSecondsTotal() {
		return secondsTotal;
	}

	public void setSecondsTotal(Long secondsTotal) {
		this.secondsTotal = secondsTotal;
	}

	public synchronized boolean addKidToPlaySite(Kid kid) {
		boolean addedSuccessfully = false;
		if (kidsCurrentlyUsing.size() < maximumKids) {
			kidsCurrentlyUsing.add(kid);
			this.dateStarted = new Date();
			addedSuccessfully = true;
		} else {
			try {
				addWaitingKidToPlaySite(kid);
			} catch (WaitingIsNotAcceptedException e) {
				e.printStackTrace();
			}
		}
		return addedSuccessfully;
	}
	
	public synchronized void removeKidFromPlaySite(Kid kid) throws PlaySiteIsEmptyException {
		if (!kidsCurrentlyUsing.isEmpty()) {
			for (Iterator<Kid> kidIter = kidsCurrentlyUsing.listIterator(); kidIter.hasNext();) {
				if (kidIter.next().getId().equals(kid.getId()) ) {
					// Perform accounting
					this.dateFinished = new Date();
					this.secondsTotal = this.getDateFinished().getTime() - this.getDateFinished().getTime();
					kid.addPlaySiteSummary(new PlaySiteSummary(
																this.getId(),
																this.getSecondsTotal(), 
																this.getDescription(),
																this.calculateUtilization()
															  ));
					addHistoryUsage(kid, secondsTotal);
					
					kidIter.remove();
				}
			}
		} else {
			throw new PlaySiteIsEmptyException();
		}
	}
	
	public synchronized void addWaitingKidToPlaySite(Kid kid) throws WaitingIsNotAcceptedException {
		if (kid.isWaitingAccepted()) {
			waitingKids.add(kid);
		} else {
			throw new WaitingIsNotAcceptedException();
		}
	}
	
	public synchronized void removeWaitingKidFromPlaySite(Kid kid) throws WaitingListIsEmptyException {
		if (!waitingKids.isEmpty()) {
			for (Iterator<Kid> kidIter = waitingKids.listIterator(); kidIter.hasNext();) {
				if (kidIter.next().getId().equals(kid.getId()) ) {
					kidIter.remove();
				}
			}
		} else {
			throw new WaitingListIsEmptyException();
		}
		
	}
	
	public synchronized void addHistoryUsage(Kid kid, Long secondsTotal) {
		KidSummary kidSummary = new KidSummary();
		kidSummary.setKidId(kid.getId());
		kidSummary.setName(kid.getName());
		kidSummary.setAge(kid.getAge());
		kidSummary.setSeconds(secondsTotal);
		
		usageHistory.add(kidSummary);
		if (usageHistory.size() > lastKidsUsed) {
			usageHistory.remove(0);
		}
	}
	
	
	@Override
	public String toString() {
		return this.description + " with capacity " + this.maximumKids + " kids";
	}

	public abstract Double calculateUtilization();
	
}
