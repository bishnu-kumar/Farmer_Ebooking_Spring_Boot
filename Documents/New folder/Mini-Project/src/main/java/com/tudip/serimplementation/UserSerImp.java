package com.tudip.serimplementation;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tudip.entity.User;
import com.tudip.repository.BookingRepository;
import com.tudip.repository.UserRepository;

@Service
public class UserSerImp {
	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		user.setActive(true);
		user.setStatus(true);
		user.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		return userRepository.save(user);

	}

	public User userLogin(User user) throws Exception {
		User presentUser = userRepository.findUserByMobileNumberAndPassword(user.getMobileNumber(), user.getPassword());
		if (presentUser != null) {
			return presentUser;

		} else {
			throw new Exception("Invalid Data");
		}
	}

	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	public User updateUser(User user) throws Exception {
		if (userRepository.existsById(user.getUserId())) {
			User presentUser = userRepository.findFarmerById(user.getUserId());
			presentUser.setUpdatedTime((new Timestamp(System.currentTimeMillis())));
			presentUser.setName(user.getName());
			presentUser.setGender(user.getGender());
			presentUser.setAddress(user.getAddress());
			presentUser.setMobileNumber(user.getMobileNumber());

			return userRepository.save(presentUser);
		} else {
			throw new Exception("User not found");
		}
	}

	public boolean deleteUser(Long userId) throws Exception {
		if (userRepository.existsById(userId)) {
			User user = new User();
			user = userRepository.findUserById(userId);
			user.setActive(false);
			userRepository.save(user);
			return true;
		} else {
			throw new Exception("user not found");
		}
	}

}