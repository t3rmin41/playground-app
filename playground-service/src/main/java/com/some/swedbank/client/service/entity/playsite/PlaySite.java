package com.some.swedbank.client.service.entity.playsite;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.some.swedbank.client.service.entity.DomainEntity;
import com.some.swedbank.client.service.entity.person.Kid;
import com.some.swedbank.client.service.exception.PlaySiteIsEmptyException;
import com.some.swedbank.client.service.exception.WaitingIsNotAcceptedException;
import com.some.swedbank.client.service.exception.WaitingListIsEmptyException;

public abstract class PlaySite extends DomainEntity {

	private Long maximumKids;
	private String description;
	
	private List<Kid> kidsCurrentlyUsing;
	private List<Kid> waitingKids;

	private Date dateStarted;
	private Date dateFinished;
	private Long secondsTotal;
	
	public PlaySite(Long id) {
		super(id);
		kidsCurrentlyUsing = new ArrayList<Kid>();
		waitingKids = new ArrayList<Kid>();
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
	
	public void addKidToPlaySite(Kid kid) {
		if (kidsCurrentlyUsing.size() < maximumKids) {
			kidsCurrentlyUsing.add(kid);
			this.dateStarted = new Date();
		} else {
			try {
				addWaitingKidToPlaySite(kid);
			} catch (WaitingIsNotAcceptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeKidFromPlaySite(Kid kid) throws PlaySiteIsEmptyException {
		if (!kidsCurrentlyUsing.isEmpty()) {
			for (Iterator<Kid> kidIter = kidsCurrentlyUsing.listIterator(); kidIter.hasNext();) {
				if (kidIter.next().getId().equals(kid.getId()) ) {
					this.dateFinished = new Date();
					this.secondsTotal = this.getDateFinished().getTime() - this.getDateFinished().getTime();
					kid.addPlaySiteSummary(new PlaySiteSummary(this.getId(), this.getSecondsTotal(), this.getDescription()));
					
					kidIter.remove();
				}
			}
		} else {
			throw new PlaySiteIsEmptyException();
		}
	}
	
	public void addWaitingKidToPlaySite(Kid kid) throws WaitingIsNotAcceptedException {
		if (kid.isWaitingAccepted()) {
			waitingKids.add(kid);
		} else {
			throw new WaitingIsNotAcceptedException();
		}
	}
	
	public void removeWaitingKidFromPlaySite(Kid kid) throws WaitingListIsEmptyException {
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
	
	@Override
	public String toString() {
		return this.description + " with capacity " + this.maximumKids + " kids";
	}

	public abstract Double calculateUtilization();
	
}
