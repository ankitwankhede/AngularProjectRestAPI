package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.Payment;
import com.example.demo.repository.PaymentRespository;

@Service
@Transactional

public class PaymentService {

	@Autowired
	PaymentRespository payment;

	// ------------------allpayment--------------------
	public List<Payment> getpayment() {
		return payment.findAll();
	}

	// ----------------getPaymentbyid------------------------
	public Payment getPaymentbyid(int id) {
		Optional<Payment> pay = payment.findById(id);
		Payment paym = null;
		try {
			paym = pay.get();
		} catch (NoSuchElementException e) {
			return null;
		}
		return paym;
	}

	// ------------------registerPayment-----------------------------
	public boolean registerpayment(Payment p) {
		Payment p1 = payment.save(p);
		if (p1 != null) {
			return true;
		} else {
			return false;
		}
	}

	// paras
	public List<Payment> getReportByPaymentDate(Date beginDate, Date endDate) {
		return payment.findReportByPaymentDate(beginDate, endDate);
	}

}
