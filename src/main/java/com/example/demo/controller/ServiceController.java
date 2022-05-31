package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Services;
import com.example.demo.service.ServiceService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class ServiceController {
	@Autowired
	ServiceService service;

//--------------AllService------------------------

	@GetMapping("/allservice")
	public List<Services> getAll() {
		return service.getservice();
	}

//--------------RegisterSerive------------------------

	@PostMapping("/registerservice")
	public boolean registeruser(@RequestBody Services s) {
		return service.registerservice(s);
	}

//--------------getservivebyid------------------------

	@GetMapping("/getservicebyid/{id}")
	public Services getuserbyid(@PathVariable("id") int id) {
		return service.getservivebyid(id);
	}
}
