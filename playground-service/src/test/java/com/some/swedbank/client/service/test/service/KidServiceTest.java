package com.some.swedbank.client.service.test.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.some.swedbank.client.service.entity.person.Kid;
import com.some.swedbank.client.service.mapper.KidDomainMapperWithDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-test-context.xml")
public class KidServiceTest {

	@Autowired
	private KidDomainMapperWithDao kidMapper;
	
	@Test
	public void mappingKidOK() {
		Kid kid = kidMapper.getKidById(1L);
		if (kid != null && kid.getId().equals(1L)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
}
