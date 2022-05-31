package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Payment;
import com.example.demo.service.PaymentService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class PaymentController {

	@Autowired
	PaymentService payment;

	// ---------------------------allPayment---------------------------------------
	@GetMapping("/allpayment")
	public List<Payment> getpayment() {
		return payment.getpayment();
	}

	// -----------------------------Registerpayment----------------------------------
	@PostMapping("/registerpayment")
	public boolean registerpayment(@RequestBody Payment p) {
		return payment.registerpayment(p);
	}

	// ------------------------------Getbyidpayment----------------------------------
	@GetMapping("/getpaymentbyid")
	public Payment getpaymentbyid(@RequestParam("transactionid") int id) {
		return payment.getPaymentbyid(id);
	}

	// paras
	@GetMapping("/getReportsByPaymentDate/{beginDate}/{endDate}")
	public List<Payment> getReportByPaymentdate(@PathVariable Date beginDate, @PathVariable Date endDate) {
		return payment.getReportByPaymentDate(beginDate, endDate);
	}

}
