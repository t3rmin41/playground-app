package com.some.swedbank.client.dao.entity;


public class KidDao extends DaoEntity {

	private String name;
	private Long age;
	private String ticketNumber;
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
