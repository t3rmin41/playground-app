package com.some.swedbank.client.service.entity.playsite;

public class BallPit extends PlaySite {

	public BallPit(Long id, Long maximumKids) {
		super(id, maximumKids);
	}
	
	public BallPit(Long id, Long maximumKids, String description) {
		super(id, maximumKids, description);
	}

	@Override
	public Double calculateUtilization() {
		return (double) getKidsCurrentlyUsing().size()/getMaximumKids();
	}

}
