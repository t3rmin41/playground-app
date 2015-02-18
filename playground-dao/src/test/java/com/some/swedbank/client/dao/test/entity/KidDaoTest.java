package com.some.swedbank.client.dao.test.entity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.some.swedbank.client.dao.entity.KidDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dao-test-context.xml")
public class KidDaoTest {
	
	@Test
	public void KidDaoOK() {
		KidDao kidDao = new KidDao(0L, "TEST",  0L, "TEST", Boolean.TRUE);
		if (kidDao.isWaitingAccepted().equals(true)) { // autoboxing check
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
}
