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

@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;

	@Column(name = "date_payment")
	private Date date_payment;

	@Column(name = "amount")
	private int amount;

	@ManyToOne
	@JoinColumn(name = "orderid")
	private Order order;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Date date_payment, int amount, Order order) {
		super();
		this.date_payment = date_payment;
		this.amount = amount;
		this.order = order;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public Date getDate_payment() {
		return date_payment;
	}

	public int getAmount() {
		return amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public void setDate_payment(Date date_payment) {
		this.date_payment = date_payment;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}