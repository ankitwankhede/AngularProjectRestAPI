package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.pojos.Enquire;
import com.example.demo.repository.EnquireRepository;

@Service
@Transactional
public class EnquireService {

	@Autowired
	EnquireRepository enquire;

	// ----------------------allEnquire----------------
	public List<Enquire> getAll() {
		return enquire.findAll();
	}

	public List<Enquire> getUserEnquire(int id) {
		return enquire.getEnquireById(id);
	}

	// ---------------------registeration--------------
	public boolean insertenquire(Enquire u) {
		Enquire u1 = enquire.save(u);
		if (u1 != null) {
			// return "Saved : orderid:" + u.getEnquireid();
			return true;
		} else {
			// return "Failed : orderid:" + u.getEnquireid();
			return false;
		}
	}

	// -------------------getenquirebyid-------------------
	public Enquire getenquirebyid(int id) {
		Optional<Enquire> enquireo = enquire.findById(id);
		Enquire enquire1 = null;
		try {
			enquire1 = enquireo.get();
		} catch (NoSuchElementException e) {
			return null;
		}
		return enquire1;
	}

	// -------------------------updateenquire---------------
	public String updateenquire(Enquire u) {
		Enquire u1 = enquire.save(u);
		if (u1 != null) {
			return "Update : orderid:" + u.getEnquireid();
		} else {
			return "Failed : orderid:" + u.getEnquireid();
		}
	}
	
	//priti
	public List<Enquire> viewRequestById(int id) {
		return enquire.getSerProviderEnquireById(id);
	}
	
	public boolean updateAvailable(int id) {
		if (enquire.changeAvailable(id) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
