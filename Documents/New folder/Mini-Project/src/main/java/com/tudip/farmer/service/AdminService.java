package com.tudip.farmer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tudip.entity.Admin;
import com.tudip.entity.Booking;
@Service
public interface AdminService {
	
	Admin save(Admin admin);
	List<Booking> adminLogin(Admin admin);

}
