package com.tudip.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tudip.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	//@Transactional
	//@Modifying
	//@Query(" Update admin t set t.loginstatus=:bool where t.id=:id and t.password=:password ")
	//public Integer adminLogIn(@Param("id") Long id, @Param("bool") boolean bool, @Param("password") String password);
	
	@Query("select u from Admin u where u.mobileNumber=?1 and u.password=?1")
	 Admin findAdminByMobileNumberAndPassword(String mobileNumber, String password);
	

}
