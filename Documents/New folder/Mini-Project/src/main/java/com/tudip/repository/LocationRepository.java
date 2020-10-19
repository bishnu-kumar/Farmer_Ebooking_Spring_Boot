package com.tudip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tudip.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
    
	@Query("select u from Location u where u.locationId=?1")
	Location findLocationById(Long locationId);

	
	
}
