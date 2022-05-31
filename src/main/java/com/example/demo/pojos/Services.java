package com.example.demo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "services")
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceid;

	@Column(name = "Servicetype", length = 30)
	private String servicetype;

	@Column(name = "Servicedesc", length = 60)
	private String servicedesc;

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Services(String servicetype, String servicedesc) {
		super();
		this.servicetype = servicetype;
		this.servicedesc = servicedesc;
	}

	public int getServiceid() {
		return serviceid;
	}

	public String getServicetype() {
		return servicetype;
	}

	public String getServicedesc() {
		return servicedesc;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public void setServicedesc(String servicedesc) {
		this.servicedesc = servicedesc;
	}

}
