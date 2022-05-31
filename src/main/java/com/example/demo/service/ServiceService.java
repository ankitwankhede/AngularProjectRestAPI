package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.pojos.Services;
import com.example.demo.repository.ServiceRepository;

@Service
@Transactional
public class ServiceService {

	@Autowired
	ServiceRepository service;

	// ------------allservice--------------------------------
	public List<Services> getservice() {
		return service.findAll();
	}

	// ------------EnterNewServices-----------------------------
	public boolean registerservice(Services s) {
		Services s1 = service.save(s);
		if (s1 != null) {
			return true;
		} else {
			return false;
		}
	}

	// ------------------getservicebyid--------------------------
	public Services getservivebyid(int id) {
		Optional<Services> serviceo = service.findById(id);
		Services service1 = null;
		try {
			service1 = serviceo.get();
		} catch (NoSuchElementException e) {
			return null;
		}
		return service1;
	}

}