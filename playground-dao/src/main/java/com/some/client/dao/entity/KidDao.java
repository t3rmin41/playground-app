package com.some.client.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

//@Entity
//@Table(name="kids")
public class KidDao extends DaoEntity {
	
	//@Column(name="name")
	private String name;
	
	//@Column(name="age")
	private Long age;
	
	//@Column(name="ticket_number")
	private String ticketNumber;
	
	//@Type(type="yes_no")
	private Boolean waitingAccepted;
	
	public KidDao(Long id, String name, Long age, String ticketNumber, Boolean waitingAccepted) {
		super(id);
		this.name = name;
		this.age = age;
		this.ticketNumber = ticketNumber;
		this.waitingAccepted = waitingAccepted;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Boolean isWaitingAccepted() {
		return waitingAccepted;
	}

	public void setWaitingAccepted(Boolean waitingAccepted) {
		this.waitingAccepted = waitingAccepted;
	}
}
