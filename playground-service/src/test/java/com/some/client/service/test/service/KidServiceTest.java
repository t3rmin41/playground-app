package com.some.client.service.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.some.client.service.entity.person.Kid;
import com.some.client.service.mapper.KidDomainMapperWithDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-test-context.xml")
public class KidServiceTest {

	@Autowired
	private KidDomainMapperWithDao kidMapper;
	
	@Test
	public void kidServiceOK() {
		Kid kid = kidMapper.getKidById(1L);
		assertNotNull(kid);
		assertEquals(1, (long) kid.getId());
	}
}
