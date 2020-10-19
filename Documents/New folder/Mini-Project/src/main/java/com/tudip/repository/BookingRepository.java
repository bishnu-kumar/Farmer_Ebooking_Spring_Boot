package com.tudip.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tudip.entity.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {

	@Query("select u from Booking u where u.bookingId=?1 and active=true ")
	Booking findBookingById(Long id);

	@Query("select u from Booking u where u.active=true  ")
	List<Booking> findAllBooking();

	@Query("select u from Booking u where u.bookingId=?1 ")
	Booking deleteBookingById(Long bookingId);

}
