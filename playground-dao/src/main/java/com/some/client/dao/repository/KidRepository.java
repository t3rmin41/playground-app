package com.some.client.dao.repository;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.some.client.dao.entity.KidDao;

@Repository
public class KidRepository {
	
	/*
	@PersistenceContext(unitName="entityManager")
	private EntityManager entityManager;
	/**/
	
	public List<KidDao> getAllKids() {
		/*
		TypedQuery<KidDao> query = entityManager.createQuery(
				"SELECT k FROM " + KidDao.class.getSimpleName() + " c "  
						  + "WHERE c.id IS NOT NULL ",KidDao.class);
		/**/
		List<KidDao> kidList = new LinkedList<KidDao>();
		
		//kidList.addAll(query.getResultList());
		
		kidList.add(new KidDao(1L, "Thomas", 7L, "12345", false));
		kidList.add(new KidDao(2L, "Jonas", 7L, "ABCDE", true));
		
		kidList.add(new KidDao(3L, "Sven", 8L, "54321", true));
		kidList.add(new KidDao(4L, "Marta", 6L, "777AAA", true));
		kidList.add(new KidDao(5L, "Greta", 8L, "111BBB", false));
		
		return kidList;
	}
	
	public KidDao getKidById(Long id) {
		String kidId = id.toString();
		switch (kidId) {
			case "1" : return new KidDao(1L, "Thomas", 7L, "12345", false);
			case "2" : return new KidDao(2L, "Jonas", 7L, "ABCDE", true);
			case "3" : return new KidDao(3L, "Sven", 8L, "54321", true);
			case "4" : return new KidDao(4L, "Marta", 6L, "777AAA", true);
			case "5" : return new KidDao(5L, "Greta", 8L ,"111BBB", false);
		}
		return null;
	}
}
