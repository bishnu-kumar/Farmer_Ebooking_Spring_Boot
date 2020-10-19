package com.tudip.serimplementation;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tudip.entity.Booking;
import com.tudip.repository.BookingRepository;
import com.tudip.repository.FarmRepository;
import com.tudip.repository.ProductRepository;
import com.tudip.repository.UserRepository;

@Service
public class BookingSerImp {
	@Autowired
	private BookingRepository bookingrepository;
	@Autowired
	private FarmRepository farmRepository;
	@Autowired
	private ProductRepository productRepository;
	
	
	

	public Booking booking(Booking booking, Long farmId) {
		
		
		booking.setProduct(productRepository.findProductById(booking.getProductIds()));
		booking.setActive(true);
		booking.setFarm(farmRepository.findFarmBYId(farmId));
		productRepository.findProductById(booking.getProductIds());
		booking.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		return bookingrepository.save(booking);
      }



	public Booking findBookingById(Long bookingId) throws Exception {
	if(bookingrepository.existsById(bookingId))
	{
		return bookingrepository.findBookingById(bookingId);
	}
	else throw new Exception("user not found");
	}



	public List<Booking> findAllBooking() {
		
		return bookingrepository.findAllBooking();
	}



	public Booking updateBooking(Booking booking) throws Exception {
		
		if(bookingrepository.findBookingById(booking.getBookingId()) != null) {
			Booking present = new Booking();
			present = bookingrepository.findBookingById(booking.getBookingId());
			present.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
			present.setBookingName(booking.getBookingName());
			present.setProductIds(booking.getProductIds());
			present.setProduct(productRepository.findProductById(booking.getProductIds()));
			return bookingrepository.save(present);
			
		}
	    
		else {
			throw new Exception("Data Not found");
		}
		
		
	}



	public boolean deleteBooking(Long bookingId) {
		Booking booking = new Booking();
		booking = bookingrepository.deleteBookingById(bookingId);
		booking.setActive(false);
		bookingrepository.save(booking);
		return true;
	}

	
}
