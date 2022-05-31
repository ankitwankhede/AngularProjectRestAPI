package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.Order;
import com.example.demo.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	OrderRepository order;

	// ------------------------------getall-----------------------------
	public List<Order> getallorder() {
		return order.findAll();
	}

	public List<Order> getbookedorderbyid(int id) {
		return order.findBookedOrderById(id);
	}

	public List<Order> getOldOrder(int id) {
		return order.getServedOrder(id);
	}

	// ---------------------------registerorder-------------------------------
	public boolean registerOrder(Order s) {
		Order s1 = order.save(s);
		if (s1 != null) {
			return true;
		} else {
			return false;
		}
	}

	// -------------------------getorderid----------------------------------
	public Order getOrderByID(int id) {
		Optional<Order> or = order.findById(id);
		Order order = null;
		try {
			order = or.get();
		} catch (NoSuchElementException e) {
			order = null;
		}
		return order;
	}

	// ----------------------updateorder-------------------------------------

	public String updateorder(Order s) {
		Order s1 = order.save(s);
		if (s1 != null) {
			return "Saved : orderid:" + s.getOrderid();
		} else {
			return "Failed : orderid:" + s.getOrderid();
		}

	}

	public boolean updatePayment(int id) {
		if (order.changePayment(id) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<Order> getOrdersByDate(Date beginDate, Date endDate) {
		return order.findOrdersByDate(beginDate, endDate);
	}

	// priti
	public List<Order> viewbookedservices(int id) {
		return order.viewBookedServiceById(id);
	}

	public List<Order> viewHistoryById(int id) {
		return order.viewHistoryById(id);
	}
}
