package com.tudip.farmer.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tudip.entity.Location;

@Repository
public interface LocationService {
	Location save(Location location);

	List<Location> findAll();

	Location findLocationById(Long locationId);

	Location updateLocation(Location location);

	public boolean deleteLocationById(Long locationId);

}
