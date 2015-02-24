package com.some.client.service.entity.playsite;

public class Slide extends PlaySite {

	public Slide(Long id, Long maximumKids) {
		super(id, maximumKids);
	}
	
	public Slide(Long id, Long maximumKids, String description) {
		super(id, maximumKids, description);
	}

	@Override
	public Double calculateUtilization() {
		return (double) getKidsCurrentlyUsing().size()/getMaximumKids();
	}

}
