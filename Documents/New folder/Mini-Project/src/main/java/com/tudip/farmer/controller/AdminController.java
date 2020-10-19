package com.tudip.farmer.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tudip.entity.Admin;
import com.tudip.entity.Booking;
import com.tudip.serimplementation.AdminSerImp;

@RestController
public class AdminController {
	@Autowired
	private AdminSerImp service; 
	

	
	@GetMapping("/adminlogin")
	public Admin adminLogin(@RequestBody Admin admin ) throws Exception {
    return service.adminLogin(admin);	
	
	}
	
}

