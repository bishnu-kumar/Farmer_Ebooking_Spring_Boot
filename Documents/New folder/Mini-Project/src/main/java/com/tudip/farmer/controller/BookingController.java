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

import com.tudip.entity.Booking;
import com.tudip.serimplementation.BookingSerImp;

@RestController
public class BookingController {

	@Autowired
	private BookingSerImp bookingservice;

	@PostMapping("/createbooking/{farmId}")
	public Booking booking(@RequestBody Booking booking, @PathVariable Long farmId) {
		return bookingservice.booking(booking, farmId);

	}

	@GetMapping("/findbookingbyid/{bookingId}")
	public Booking findBookingById(@PathVariable Long bookingId) throws Exception {
		return bookingservice.findBookingById(bookingId);
	}

	@GetMapping("/findallbooking")
	public List<Booking> findAllBooking() {
		return bookingservice.findAllBooking();
	}

	@PutMapping("/updatebooking")
	public Booking updateBooking(@RequestBody Booking booking) throws Exception {
		return bookingservice.updateBooking(booking);

	}
	
	@DeleteMapping("deletebookingbyid/{bookingId}")
	public boolean deleteBookingById(@PathVariable Long bookingId) {
		
		return bookingservice.deleteBooking(bookingId);
	}

}
