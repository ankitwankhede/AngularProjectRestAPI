package com.example.demo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "serviceprovider")
public class ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceproviderid;

	@Column(name = "username", length = 15, unique = true)
	private String username;

	@ManyToOne
	@JoinColumn(name = "serviceid")
	private Services services;

	@Column(name = "first_name", length = 15)
	private String first_name;

	@Column(name = "last_name", length = 25)
	private String last_name;

	@Column(name = "email", length = 15)
	private String email;

	@Column(name = "password", length = 15)
	private String password;

	@Column(name = "mobile_no")
	private String mobile_no;

	@Column(name = "add_line1", length = 100)
	private String add_line1;

	@Column(name = "add_line2", length = 100)
	private String add_line2;

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isActive;

	@Column(name = "experience_year")
	private int experience_year;

	@Column(name = "charges")
	private int charges;

	@Column(name = "servicedesc", length = 100)
	private String servicedesc;

	@Column(name = "agency_name")
	private String agencyname;

	public ServiceProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public ServiceProvider(String username, Services services, String first_name, String last_name, String email,
//			String password, String mobile_no, String add_line1, String add_line2, boolean isActive,
//			int experience_year, int charges, String servicedesc) {
//		super();
//		this.username = username;
//		this.services = services;
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.email = email;
//		this.password = password;
//		this.mobile_no = mobile_no;
//		this.add_line1 = add_line1;
//		this.add_line2 = add_line2;
//		this.isActive = isActive;
//		this.experience_year = experience_year;
//		this.charges = charges;
//		this.servicedesc = servicedesc;
//	}

	public int getServiceproviderid() {
		return serviceproviderid;
	}

	public ServiceProvider(int serviceproviderid, String username, Services services, String first_name,
			String last_name, String email, String password, String mobile_no, String add_line1, String add_line2,
			boolean isActive, int experience_year, int charges, String servicedesc, String agencyname) {
		super();
		this.serviceproviderid = serviceproviderid;
		this.username = username;
		this.services = services;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.mobile_no = mobile_no;
		this.add_line1 = add_line1;
		this.add_line2 = add_line2;
		this.isActive = isActive;
		this.experience_year = experience_year;
		this.charges = charges;
		this.servicedesc = servicedesc;
		this.agencyname = agencyname;
	}

	public void setServiceproviderid(int serviceproviderid) {
		this.serviceproviderid = serviceproviderid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getAdd_line1() {
		return add_line1;
	}

	public void setAdd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}

	public String getAdd_line2() {
		return add_line2;
	}

	public void setAdd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getExperience_year() {
		return experience_year;
	}

	public void setExperience_year(int experience_year) {
		this.experience_year = experience_year;
	}

	public int getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}

	public String getServicedesc() {
		return servicedesc;
	}

	public void setServicedesc(String servicedesc) {
		this.servicedesc = servicedesc;
	}

	public String getAgencyname() {
		return agencyname;
	}

	public void setAgencyname(String agencyname) {
		this.agencyname = agencyname;
	}

}