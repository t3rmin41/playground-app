package com.some.client.service.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.some.client.service.entity.park.AmusementPark;
import com.some.client.service.mapper.AmusementParkDomainMapperWithDao;

//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-test-context.xml")
public class AmusementParkServiceTest {

	@Autowired
    private AmusementParkDomainMapperWithDao amusementParkMapper;
	
	@Test
	public void amusementParkServiceOK() {
		AmusementPark park = amusementParkMapper.getAmusementPark(3L);
		assertNotNull(park);
		assertEquals(4, (long) park.getPlaySites().size());
	}
}
