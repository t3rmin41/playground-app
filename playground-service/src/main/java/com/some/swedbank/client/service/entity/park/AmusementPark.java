package com.some.swedbank.client.service.entity.park;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.some.swedbank.client.service.entity.DomainEntity;
import com.some.swedbank.client.service.entity.person.Kid;
import com.some.swedbank.client.service.entity.playsite.PlaySite;
import com.some.swedbank.client.service.entity.playsite.PlaySiteSummary;

public class AmusementPark extends DomainEntity {

	private List<PlaySite> playSites;
	private List<AmusementParkSummary> snapshots;
	private Long visitorsTotal = 0L;
	
	public AmusementPark(Long id) {
		super(id);
		this.playSites = new ArrayList<PlaySite>();
		this.snapshots = new ArrayList<AmusementParkSummary>();
	}
	
	public AmusementPark(Long id, List<PlaySite> list) {
		this(id);
		this.playSites = list;
		makeSnapshot();
	}

	public List<PlaySite> getPlaySites() {
		return playSites;
	}

	public void setPlaySites(List<PlaySite> playSites) {
		this.playSites = playSites;
	}
	
	public List<AmusementParkSummary> getSnapshots() {
		return snapshots;
	}

	public void setSnapshots(List<AmusementParkSummary> snapshots) {
		this.snapshots = snapshots;
	}

	public Long getVisitorsTotal() {
		return visitorsTotal;
	}

	public void setVisitorsTotal(Long visitorsTotal) {
		this.visitorsTotal = visitorsTotal;
	}

	public void addNewPlaySite(PlaySite playSite) {
		this.playSites.add(playSite);
	}
	
	public void removePlaySite(PlaySite playSite) {
		for (Iterator<PlaySite> playSiteIter = playSites.listIterator(); playSiteIter.hasNext();) {
			if (playSiteIter.next().getId().equals(playSite.getId()) ) {
				playSiteIter.remove();
			}
		}
	}
	 
	public void addKidToPlaySite(PlaySite playSite, Kid kid) {
		if (this.playSites.contains(playSite) && playSite.addKidToPlaySite(kid)) {
			visitorsTotal++;
		}
	}
	
	public void makeSnapshot() {
		AmusementParkSummary parkSummary = new AmusementParkSummary(this.getId());
		List<PlaySiteSummary> playSiteSumList = new ArrayList<PlaySiteSummary>();
		for (PlaySite playSite : this.playSites) {
			playSiteSumList.add(new PlaySiteSummary(
											  playSite.getId(),
											  playSite.getDescription(),
											  playSite.calculateUtilization()
						  ));
		}
		parkSummary.setPlaySiteSummaries(playSiteSumList);
		parkSummary.setTotalVisitors(visitorsTotal);
		snapshots.add(parkSummary);
	}
}
