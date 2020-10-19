package com.tudip.serimplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tudip.entity.Admin;
import com.tudip.entity.Booking;
import com.tudip.repository.AdminRepository;
import com.tudip.repository.BookingRepository;

@Service
public class AdminSerImp {
	@Autowired
	private AdminRepository adminRepository;
	//@Autowired
   // private BookingRepository bookingRepository;

	

	public Admin adminLogin(Admin admin) throws Exception {

		Admin presentUser = adminRepository.findAdminByMobileNumberAndPassword(admin.getMobileNumber(),admin.getPassword());
		if (admin.getMobileNumber().equals(presentUser.getMobileNumber())
				&& admin.getPassword().equals(presentUser.getPassword())) {
			return presentUser;
		} else {
			throw new Exception("Enter valid Admin detail");
		}

	}

}
