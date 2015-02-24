package com.some.client.service.test.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.some.client.dao.entity.AmusementParkDao;
import com.some.client.dao.repository.AmusementParkRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-test-context.xml")
public class AmusementParkMapperTest {

	@Autowired
	private AmusementParkRepository amusementParkRepository;
	
	@Test
	public void amusementParkMapperOK() {
		AmusementParkDao dao = amusementParkRepository.loadAmusementPark(2L);
		assertNotNull(dao);
		assertEquals(3, (long) dao.getPlaySitesDao().size());
	}
}
