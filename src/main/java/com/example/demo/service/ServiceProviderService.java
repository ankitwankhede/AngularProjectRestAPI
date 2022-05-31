package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.ServiceProvider;
import com.example.demo.pojos.Services;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.serviceProviderRepository;

@Service
@Transactional
public class ServiceProviderService {

	@Autowired
	serviceProviderRepository servicepro;

	@Autowired
	ServiceRepository serrepo;

	// ------------allServiceProvider--------------------------------
	public List<ServiceProvider> getserviceprovider() {
		return servicepro.findAll();
	}

	public List<ServiceProvider> getall() {
		return servicepro.getActiveSerPro();
	}

	// ------------registerServiceProvider-----------------------------

	public boolean registerserviceprovider(ServiceProvider s) {

		// Services ser= s.getService();

//		Optional<Services> ser = serrepo.findById(s.getServices().getServiceid());
//		Services services = ser.get();
//		s.setServices(services);

		ServiceProvider s1 = servicepro.save(s);
		if (s1 != null) {
			// return "Saved : userid" + s.getServiceproviderid();
			return true;
		} else {
			// return "Failed : userid" + s.getServiceproviderid();
			return false;
		}
	}

	// ------------------getServiceProviderbyid--------------------------
	public ServiceProvider getserviceproviderbyid(int id) {
		Optional<ServiceProvider> serviceproo = servicepro.findById(id);
		ServiceProvider serviceproo1 = null;
		try {
			serviceproo1 = serviceproo.get();
		} catch (NoSuchElementException e) {
			return null;
		}
		return serviceproo1;
	}

	// -------------------updateServiceProvider-----------------------------
	public String updateserviceprovider(ServiceProvider s) {
		ServiceProvider s1 = servicepro.save(s);
		if (s1 != null) {
			return "Update : orderid:" + s.getServiceproviderid();
		} else {
			return "Failed : orderid:" + s.getServiceproviderid();
		}
	}

	public boolean checkServiceProvider(String username, String password) {
		if (servicepro.checkServiveProvider(username, password) != null) {
			return true;
		} else {
			return false;
		}
	}
	public boolean updatestatus(int id)
	{
		if(servicepro.updatestatus(id)==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public ServiceProvider getServiceproviderByUserNm(String usnm) {
		return servicepro.getServiceProvider(usnm);
	}

	public List<ServiceProvider> getbyservices(Services services)
	{
		return servicepro.findByServices(services);
	}
	
	// filteron basis of servicess
	public List<ServiceProvider> checkServiceProviderbyServiceid(int id) {

		return servicepro.checkServiceProviders(id);
	}

	public boolean updateServiceProvider(String email, String mobile_no, String add_line1, String add_line2,
			String username) {
		int ser = servicepro.updateServiceProvider(email, mobile_no, add_line1, add_line2, username);
		if (ser == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean changeSerProstatus(int id) {
		if (servicepro.updatestatus(id) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
