package com.example.demo.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;

	@Column(name = "username", length = 15, unique = true)
	private String username;

	@Column(name = "first_name", length = 15)
	private String first_name;

	@Column(name = "last_name", length = 25)
	private String last_name;

	@Column(name = "email")
	private String email;

	@Column(name = "password", length = 15)
	private String password;

	@Column(name = "mobile_No", length = 10)
	private String mobile_no;

	@Column(name = "add_line1", length = 100)
	private String add_line1;

	@Column(name = "add_line2", length = 100)
	private String add_line2;

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isActive;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String first_name, String last_name, String email, String password, String mobile_no,
			String add_line1, String add_line2, boolean isActive) {
		super();
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.mobile_no = mobile_no;
		this.add_line1 = add_line1;
		this.add_line2 = add_line2;
		this.isActive = isActive;
	}

	public int getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public String getAdd_line1() {
		return add_line1;
	}

	public String getAdd_line2() {
		return add_line2;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public void setAdd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}

	public void setAdd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}