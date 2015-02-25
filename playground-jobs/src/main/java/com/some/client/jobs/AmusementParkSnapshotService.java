package com.some.client.jobs;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.some.client.service.AmusementParkService;
import com.some.client.service.entity.park.AmusementPark;

@Component
public class AmusementParkSnapshotService {

	final static Logger logger = Logger.getLogger(AmusementParkSnapshotService.class.getName());
	
	@Autowired
	private AmusementParkService amusementParkService;
	
	public void demoJob() {
		logger.info("Scheduled job executed with logger output. Current time is : "+ new Date());
	}
	
	public void makeAmusementParkSnapshots() {
		List<AmusementPark> parks = amusementParkService.getAllAmusementParks();
		for (AmusementPark park : parks) {
			park.makeSnapshot();
		}
	}
	/**/
}
