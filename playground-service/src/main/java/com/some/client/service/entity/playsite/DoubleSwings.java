package com.some.client.service.entity.playsite;

public class DoubleSwings extends PlaySite {

	public DoubleSwings(Long id, Long maximumKids) {
		super(id, maximumKids);
	}
	
	public DoubleSwings(Long id, Long maximumKids, String description) {
		super(id, maximumKids, description);
	}

	@Override
	public Double calculateUtilization() {
		return (double) getKidsCurrentlyUsing().size()/getMaximumKids();
	}

}
