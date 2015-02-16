package com.some.swedbank.client.dao.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.some.swedbank.client.dao.entity.KidDao;

@Repository
public class KidRepository {
	
	public List<KidDao> getAllKids() {
		List<KidDao> kidList = new LinkedList<KidDao>();
		
		kidList.add(new KidDao(1L, "Thomas", 7L, "12345", false));
		kidList.add(new KidDao(2L, "Jonas",7L,"ABCDE", true));
		kidList.add(new KidDao(3L, "Sven",8L,"54321", true));
		kidList.add(new KidDao(4L, "Marta",6L,"777AAA", true));
		kidList.add(new KidDao(5L, "Greta",8L,"111BBB", false));
		
		return kidList;
	}
}
