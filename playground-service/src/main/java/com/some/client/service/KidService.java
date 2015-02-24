package com.some.client.service;

import java.util.List;

import com.some.client.service.entity.person.Kid;

public interface KidService {
	
	List<Kid> getAllKids();
	
	Kid getKidById(Long id);
	
}
