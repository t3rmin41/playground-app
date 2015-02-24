package com.some.client.dao.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.some.client.dao.entity.KidDao;

@Repository
public class KidRepository {
	
	public List<KidDao> getAllKids() {
		List<KidDao> kidList = new LinkedList<KidDao>();
		
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
