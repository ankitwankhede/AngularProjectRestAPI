package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.User;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class UserController {

	@Autowired
	UserService user;

	// --------------Home Page------------------------
	@GetMapping("/Home")
	public String home() {
		return "this is home page";
	}

//--------------AllUser------------------------

	@GetMapping("/alluser")
	public List<User> getAll() {
		return user.getusers();
	}

//--------------Registerser------------------------

	@PostMapping("/registeruser")
	public boolean registeruser(@RequestBody User u) {
		return user.registeruser(u);
	}

//--------------getuserbyid------------------------

	@GetMapping("/getuserbyid/{id}")
	public User getuserbyid(@PathVariable int id) {
		return user.getuserbyid(id);
	}

	// --------------updateuser------------------------

//	@PutMapping("/updateuser")
//	public String updateuser(@RequestBody User u) {
//		return user.updateuser(u);
//	}
//

	@GetMapping("/login/customer/{uname}/{pwd}")
	public boolean logincustomer(@PathVariable("uname") String username, @PathVariable("pwd") String password) {
		return user.checkuser(username, password);
		// System.out.println(uid+password);
	}

	@GetMapping("/getUserByUserName/{unm}")
	public User getUser(@PathVariable("unm") String usernm) {
		return user.getUserByUserNm(usernm);
	}
}
