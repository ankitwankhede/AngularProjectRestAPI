package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.User;
import com.example.demo.repository.UserRespository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRespository user;

//------------alluser--------------------------------
	public List<User> getusers() {
		return user.findAll();
	}

//------------registeruser-----------------------------
	public boolean registeruser(User u) {
		User u1 = user.save(u);
		if (u1 != null) {
			return true;
		} else {
			return false;
		}
	}

//------------------getuserbyid--------------------------
	public User getuserbyid(int id) {
		Optional<User> usero = user.findById(id);
		User user1 = null;
		try {
			user1 = usero.get();
		} catch (NoSuchElementException e) {
			return null;
		}
		return user1;
	}

//-------------------updateuser-----------------------------
//	public String updateuser(User u) {
//		User p1 = user.save(u);
//		if (u != null) {
//			return "Update : orderid:" + u.getUserid();
//		} else {
//			return "Failed : orderid:" + u.getUserid();
//		}
//	}

	public boolean checkuser(String username, String password) {
		if (user.checkUser(username, password) != null) {
			return true;
		} else {
			return false;
		}
	}

	public User getUserByUserNm(String usnm) {
		return user.getUser(usnm);
	}

	// paras
	public boolean changestatus(int id) {
		if (user.changeUserStatus(id) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
