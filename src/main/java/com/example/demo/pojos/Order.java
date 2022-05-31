package com.example.demo.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "orderid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "order_date")
	private Date order_date;

	@Column(name = "order_count")
	private int order_count;

	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	@ManyToOne
	@JoinColumn(name = "service_providerid")
	private ServiceProvider servicepro;

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isPaid;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderid, Date order_date, int order_count, User user, ServiceProvider servicepro, boolean isPaid) {
		super();
		this.orderid = orderid;
		this.order_date = order_date;
		this.order_count = order_count;
		this.user = user;
		this.servicepro = servicepro;
		this.isPaid = isPaid;
	}

	public int getOrderid() {
		return orderid;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public int getOrder_count() {
		return order_count;
	}

	public User getUser() {
		return user;
	}

	public ServiceProvider getServicepro() {
		return servicepro;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setServicepro(ServiceProvider servicepro) {
		this.servicepro = servicepro;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

}