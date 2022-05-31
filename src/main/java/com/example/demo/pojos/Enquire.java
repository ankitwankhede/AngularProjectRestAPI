package com.example.demo.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enquire")
public class Enquire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enquireid;

//	 @Column(nullable=false,columnDefinition = "TINYINT(1)")
//	 private boolean isActive;

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isAvailable;

	@Column(name = "event_date")
	private LocalDate event_date;

	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	@ManyToOne
	@JoinColumn(name = "service_providerid")
	private ServiceProvider servicepro;

	public Enquire() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Enquire(boolean isActive, LocalDate event_date, User user, ServiceProvider servicepro) {
//		super();
//		this.isActive = isActive;
//		this.event_date = event_date;
//		this.user = user;
//		this.servicepro = servicepro;
//	}

	public int getEnquireid() {
		return enquireid;
	}

	public Enquire(int enquireid, boolean isAvailable, LocalDate event_date, User user, ServiceProvider servicepro) {
		super();
		this.enquireid = enquireid;
		this.isAvailable = isAvailable;
		this.event_date = event_date;
		this.user = user;
		this.servicepro = servicepro;
	}

//	public boolean isActive() {
//		return isActive;
//	}

	public LocalDate getEvent_date() {
		return event_date;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public User getUser() {
		return user;
	}

	public ServiceProvider getServicepro() {
		return servicepro;
	}

	public void setEnquireid(int enquireid) {
		this.enquireid = enquireid;
	}

//	public void setActive(boolean isActive) {
//		this.isActive = isActive;
//	}

	public void setEvent_date(LocalDate event_date) {
		this.event_date = event_date;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setServicepro(ServiceProvider servicepro) {
		this.servicepro = servicepro;
	}

}