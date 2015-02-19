package com.some.swedbank.client.service.test.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.some.swedbank.client.dao.entity.PlaySiteDao;
import com.some.swedbank.client.dao.repository.PlaySiteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-test-context.xml")
public class PlaySiteDomainMapperTest {

	@Autowired
	private PlaySiteRepository playSiteRepository;
	
	@Test
	public void mappingPlaySiteOK() {
		PlaySiteDao dao = playSiteRepository.loadPlaySite(2L);
		assertEquals(5, (long) dao.getMaximumKids());
	}
	
}
