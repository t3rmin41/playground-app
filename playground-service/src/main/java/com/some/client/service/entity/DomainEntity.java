package com.some.client.service.entity;

public abstract class DomainEntity {
	
	private Long id;

	public DomainEntity(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
