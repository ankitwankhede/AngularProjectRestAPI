package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.ServiceProvider;
import com.example.demo.pojos.User;
import com.example.demo.service.ServiceProviderService;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {

	@GetMapping("/login/admin/{uname}/{pwd}")
	public boolean loginAdmin(@PathVariable("uname") String username, @PathVariable("pwd") String password) {
		if (username.equals("admin123") && password.equals("12345678")) {
			return true;
		} else {
			return false;
		}

	}

	// ---------------------------------- Service Provider
	// ------------------------------------------------------

	// Service Provider

	@Autowired
	ServiceProviderService serproser;

	// get all service provider

	@GetMapping("/GetAllServiceProviders")
	public List<ServiceProvider> getAllServProv() {
		return serproser.getserviceprovider();
	}

	// update service provider account

	@GetMapping("/updateserviceproviderstatus")
	public boolean updateserviceproviderstatus(@RequestParam("serviceproviderid") int id) {
		return serproser.updatestatus(id);
	}

	// ---------------------------------- User
	// ------------------------------------------------------

	@Autowired
	UserService userserv;

	// get all users

	@GetMapping("/GetAllUsers")
	public List<User> getAllUsr() {
		return userserv.getusers();
	}

	// activate customer account

	@GetMapping("/updateUserStatus/{id}")
	public boolean updateuserstatus(@PathVariable int id) {
		return userserv.changestatus(id);
	}
	
	//activate service provider account
	@GetMapping("/updateServiceProviderStatus/{id}")
	public boolean updateServiceProviderstatus(@PathVariable int id) {
		return serproser.changeSerProstatus(id);
	}
}
