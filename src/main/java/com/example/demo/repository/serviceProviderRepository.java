package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.pojos.ServiceProvider;
import com.example.demo.pojos.Services;

public interface serviceProviderRepository extends JpaRepository<ServiceProvider, Integer> {

	ServiceProvider findByUsernameAndPassword(String tempusername, String temppassword);

	@Query("select s from ServiceProvider s where s.isActive=true")
	List<ServiceProvider> getActiveSerPro();

	@Query("SELECT s FROM ServiceProvider s WHERE s.username =?1 AND s.password =?2 AND s.isActive=true")
	ServiceProvider checkServiveProvider(String username, String password);

	@Query("select s from ServiceProvider s where s.username=?1")
	ServiceProvider getServiceProvider(String username);

	@Modifying
	@Query("update ServiceProvider set isActive=true where serviceproviderid=?1")
	int updatestatus(int id);
	//

	List<ServiceProvider> findByServices(Services services);

	@Modifying
	@Query("UPDATE ServiceProvider  SET email=?1,mobile_no=?2 ,add_line1=?3 , add_line2=?4 WHERE username=?5")
	int updateServiceProvider(String email, String mobileno, String add_line1, String add_line2, String username);

	@Query("SELECT s FROM ServiceProvider s inner join s.services a WHERE a.serviceid=?1")
	List<ServiceProvider> checkServiceProviders(int id);

}
