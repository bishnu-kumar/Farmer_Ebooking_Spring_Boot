package com.tudip.farmer.service;

import org.springframework.stereotype.Service;

import com.tudip.entity.Booking;
import com.tudip.entity.User;
@Service
public interface UserService {
	
	User save(User user);
	User userLogin(User user);
	Booking bookingById(Long id);
	//User userLogin(Long id, String password);
	 

}
