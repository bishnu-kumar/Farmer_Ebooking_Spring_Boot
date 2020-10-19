package com.tudip.farmer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tudip.entity.Booking;

@Service
public interface BookingService {
	
	Booking booking(Booking booking, Long id);
	Booking findBookingById(Long bookingId);
	List<Booking> findAllBooking();
	Booking updateBooking(Booking booking);
	boolean deleteBooking(Long bookingId);

}
