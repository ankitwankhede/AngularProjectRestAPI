package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.User;

@Repository
public interface UserRespository extends JpaRepository<User, Integer> {

	@Modifying
	@Query("update User set isActive=true where userid=?1")
	int changeUserStatus(int id);

	@Query("select u from User u where u.username=?1 AND u.password=?2 AND u.isActive=true")
	User checkUser(String username, String password);

	@Query("select u from User u where u.username=?1")
	User getUser(String username);
}
