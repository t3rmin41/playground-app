package com.some.client.service.entity.playsite;

public class Carousel extends PlaySite {

	public Carousel(Long id, Long maximumKids) {
		super(id, maximumKids);
	}
	
	public Carousel(Long id, Long maximumKids, String description) {
		super(id, maximumKids, description);
	}

	@Override
	public Double calculateUtilization() {
		return (double) getKidsCurrentlyUsing().size()/getMaximumKids();
	}

}
