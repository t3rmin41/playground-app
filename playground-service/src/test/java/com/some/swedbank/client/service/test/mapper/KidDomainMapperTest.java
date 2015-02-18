package com.some.swedbank.client.service.test.mapper;

import static org.junit.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.some.swedbank.client.dao.entity.KidDao;
import com.some.swedbank.client.dao.repository.KidRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-test-context.xml")
public class KidDomainMapperTest {
	
	@Autowired
	private KidRepository kidRepository;
	
	@Test
	public void mappingKidOK() {
		KidDao kidDao = kidRepository.getKidById(2L);
		assertNotNull(kidDao);
		assertEquals(2, (long) kidDao.getId());
	}
}
