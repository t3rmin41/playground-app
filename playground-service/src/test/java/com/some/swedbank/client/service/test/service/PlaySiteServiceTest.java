package com.some.swedbank.client.service.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.some.swedbank.client.service.entity.playsite.PlaySite;
import com.some.swedbank.client.service.mapper.PlaySiteDomainMapperWithDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-test-context.xml")
public class PlaySiteServiceTest {

	@Autowired
	private PlaySiteDomainMapperWithDao playSiteMapper;
	
	@Test
	public void playsiteServiceOK() {
		PlaySite playSite = playSiteMapper.loadPlaySite(3L);
		assertNotNull(playSite);
		assertEquals(3, (long) playSite.getId());
	}
	
}
