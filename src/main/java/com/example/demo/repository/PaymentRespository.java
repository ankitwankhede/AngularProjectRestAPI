package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Payment;

@Repository
public interface PaymentRespository extends JpaRepository<Payment, Integer> {
	// paras
	@Query("select p from Payment p where p.date_payment between ?1 and ?2")
	List<Payment> findReportByPaymentDate(Date beginDate, Date endDate);
	//

}
