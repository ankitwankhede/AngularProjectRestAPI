package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.pojos.Enquire;

public interface EnquireRepository extends JpaRepository<Enquire, Integer> {

	public final static String getEnquire = "select e from Enquire e inner join e.user u where u.userid=?1";

	@Query(getEnquire)
	List<Enquire> getEnquireById(int id);

	public final static String viewRequest = "select e from Enquire e inner join e.servicepro s where s.serviceproviderid=?1 and e.isAvailable=false";

	@Query(viewRequest)
	List<Enquire> getSerProviderEnquireById(int id);
	
	
	public final static String changeAvailable="update Enquire e set e.isAvailable=true where e.enquireid=?1";
	@Modifying
	@Query(changeAvailable)
	int changeAvailable(int id);
}
