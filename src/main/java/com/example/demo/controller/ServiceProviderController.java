package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.ServiceProvider;
import com.example.demo.service.ServiceProviderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ServiceProviderController {

	@Autowired
	ServiceProviderService servicepro;

	// --------------Allserviceprovider------------------------

	@GetMapping("/allserviceprovider")
	public List<ServiceProvider> getAll() {
		return servicepro.getserviceprovider();
	}

	// for customer provider search service
	@GetMapping("/allactiveserviceprovider")
	public List<ServiceProvider> getactiveserpro() {
		return servicepro.getall();
	}

	// --------------registerserviceprovider------------------------

	@PostMapping("/registerserviceprovider")
	public boolean registerserviceprovider(@RequestBody ServiceProvider u) {
		return servicepro.registerserviceprovider(u);
	}

	// --------------getserviceproviderbyid------------------------

	@GetMapping("/getserviceproviderbyid/{id}")
	public ServiceProvider getserviceproviderbyid(@PathVariable("id") int id) {
		return servicepro.getserviceproviderbyid(id);
	}

	// --------------updateserviceprovider------------------------

	@PutMapping("/updateserviceprovider")
	public String updateserviceprovider(@RequestBody ServiceProvider u) {
		return servicepro.updateserviceprovider(u);
	}

	@GetMapping("/login/serviceprovider/{uname}/{pwd}")
	public boolean checkServiceProvider(@PathVariable("uname") String username, @PathVariable("pwd") String password) {
		return servicepro.checkServiceProvider(username, password);
	}

	@GetMapping("/getServiceProviderByUserName/{unm}")
	public ServiceProvider getUser(@PathVariable("unm") String usernm) {
		return servicepro.getServiceproviderByUserNm(usernm);
	}

//	@GetMapping("/getbyservices")
//	public List<ServiceProvider> getbyservice(Services services) {
//		return servicepro.getbyservices(services);
//	}

	@GetMapping("/getserviceproviderbyserviceid/{serviceid}")
	public List<ServiceProvider> getserviceproviderbyservices(@PathVariable("serviceid") int id) {
		return servicepro.checkServiceProviderbyServiceid(id);
	}

	@PutMapping("/updateServiceProvider/{mail}/{mobile}/{a_line1}/{a_line2}/{uname}")
	public boolean updateServiceProvider(@PathVariable("mail") String email, @PathVariable("mobile") String mobile_no,
			@PathVariable("a_line1") String add_line1, @PathVariable("a_line2") String add_line2,
			@PathVariable("uname") String username) {
		return servicepro.updateServiceProvider(email, mobile_no, add_line1, add_line2, username);
	}

}
