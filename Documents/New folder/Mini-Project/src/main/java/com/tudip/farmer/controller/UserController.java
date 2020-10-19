package com.tudip.farmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tudip.entity.User;
import com.tudip.serimplementation.UserSerImp;

@RestController
public class UserController {
	@Autowired
	private UserSerImp farmerservice;

	@PostMapping("/addfarmer")
	public User addFarmer(@RequestBody User user) {
		return farmerservice.save(user);

	}

	@GetMapping("/userlogin")
	public User userLogin(@RequestBody User user) throws Exception {
		return farmerservice.userLogin(user);
	}
	
	@GetMapping("/findalluser")
		public List<User> findAllUser() {
		return farmerservice.findAllUser();
	}

	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) throws Exception {
		return farmerservice.updateUser(user);
		
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public boolean deleteUser(@PathVariable Long userId) throws Exception {
		return farmerservice.deleteUser(userId);
		
	}
	
}
