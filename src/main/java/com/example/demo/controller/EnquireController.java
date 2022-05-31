package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Enquire;
import com.example.demo.service.EnquireService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class EnquireController {

	@Autowired
	EnquireService enquire;

	// ------------------------ allenquire-------------------------------------
	@GetMapping("/allenquire")
	public List<Enquire> getAll() {
		return enquire.getAll();
	}

	// Ankit CustomerService angular
	@GetMapping("/getUserEnquireById/{id}")
	public List<Enquire> getAllnquire(@PathVariable int id) {
		return enquire.getUserEnquire(id);
	}
	// ------------------------ RegisterEnquire-------------------------------------

	@PostMapping("/registerenquire")
	public boolean insertenquire(@RequestBody Enquire e) {
		return enquire.insertenquire(e);
	}

	// ------------------------ getenquirebyid-------------------------------------

	@GetMapping("/getenquirebyid")
	public Enquire getuserbyID(@RequestParam("enquireid") int id) {
		return enquire.getenquirebyid(id);
	}

	// priti
	@GetMapping("/getserviceproviderenquirebyid/{id}")
	public List<Enquire> getallrequest(@PathVariable int id) {
		return enquire.viewRequestById(id);
	}

	@GetMapping("/updateAvailable/{id}")
	public boolean updtAvailable(@PathVariable int id) {
		return enquire.updateAvailable(id);
	}
}
