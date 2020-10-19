package com.tudip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tudip.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// @Query("select id from farmerentity id where id.id =?1")
	// public User findByID(Long id);

	@Query("select u from User u where u.userId=?1")
	public User findFarmerById(Long id);

	@Query("select u from User u where u.mobileNumber=?1 and u.password=?2 and u.active=true and u.status= true")
	public User findUserByMobileNumberAndPassword(String mobileNumber, String password);

	@Query("select u from User u where u.userId=?1 and u.active=true and u.status= true ")
	public User findUserById(Long userId);

}
