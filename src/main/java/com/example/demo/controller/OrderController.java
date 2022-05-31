package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Order;
import com.example.demo.service.OrderService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class OrderController {

	@Autowired
	OrderService order;

//----------------------getorder------------------------------------
	@GetMapping("/getorder")
	public List<Order> getallorder() {
		return order.getallorder();
	}

//----------------------getorderbyid------------------------------------

	@GetMapping("/getorderbyid/{id}")
	public Order getOrderByid(@PathVariable int id) {
		return order.getOrderByID(id);
	}

	@GetMapping("/getBookedOrderByID/{id}")
	public List<Order> getorders(@PathVariable int id) {
		return order.getbookedorderbyid(id);
	}

	@GetMapping("/getOldOrder/{id}")
	public List<Order> getServOrdr(@PathVariable int id) {
		return order.getOldOrder(id);
	}
//----------------------registerorder------------------------------------

	@PostMapping("/registerorder")
	public boolean registerorder(@RequestBody Order s) {
		return order.registerOrder(s);
	}

//----------------------updateorder------------------------------------

	@PutMapping("/updateorder")
	public String updateorder(Order s) {
		return order.updateorder(s);
	}

	@GetMapping("/updatePayment/{id}")
	public boolean updtPayment(@PathVariable int id) {
		return order.updatePayment(id);
	}

	// paras
	@GetMapping("/getOrderByDate/{beginDate}/{endDate}")
	public List<Order> getOrdersBydate(@PathVariable Date beginDate, @PathVariable Date endDate) {
		return order.getOrdersByDate(beginDate, endDate);
	}

	// priti
	@GetMapping("/serviceproviderviewbookedservices/{id}")
	public List<Order> viewbookedservices(@PathVariable int id) {
		return order.viewbookedservices(id);
	}

	@GetMapping("/serviceproviderhistorybyid/{id}")
	public List<Order> viewHistoryById(@PathVariable int id) {
		return order.viewHistoryById(id);
	}

}
