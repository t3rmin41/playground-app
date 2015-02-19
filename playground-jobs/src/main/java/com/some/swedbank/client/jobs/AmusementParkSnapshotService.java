package com.some.swedbank.client.jobs;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.some.swedbank.client.service.AmusementParkService;
import com.some.swedbank.client.service.entity.park.AmusementPark;

public class AmusementParkSnapshotService {

	final static Logger logger = Logger.getLogger(AmusementParkSnapshotService.class.getName());
	
	@Autowired
	private AmusementParkService amusementParkService;
	
	@Scheduled(cron = "*/5 * * * * ?")
	public void demoJob() {
		logger.info("Scheduled job executed every 5 seconds Current time is : "+ new Date());
	}
	
	@Scheduled(cron = "*/10 * * * * ?")
	public void makeAmusementParkSnapshots() {
		List<AmusementPark> parks = amusementParkService.getAllAmusementParks();
		for (AmusementPark park : parks) {
			park.makeSnapshot();
		}
	}
	/**/
}
