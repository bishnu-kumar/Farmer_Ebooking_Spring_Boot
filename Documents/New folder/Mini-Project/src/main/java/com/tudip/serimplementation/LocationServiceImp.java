package com.tudip.serimplementation;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudip.entity.Location;
import com.tudip.repository.LocationRepository;

@Service
public class LocationServiceImp {
	@Autowired
	LocationRepository locationRepository;

	public Location save(Location location) {
		location.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		location.setActive(true);
		return locationRepository.save(location);

	}

	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	public Location findLocationById(Long locationId) {
		return locationRepository.findLocationById(locationId);
	}

	public Location updateLocation(Location location) throws Exception {
		Location location1 = new Location();
		location1 = locationRepository.findLocationById(location.getLocationId());
		if (location1 != null) {
			location1.setModifieddate(new Timestamp(System.currentTimeMillis()));
			location1.setState(location.getState());
			location1.setState(location.getPlace());
			location1.setState(location.getDistrict());
			location1.setState(location.getLandArea());
			locationRepository.save(location1);
			return location1;
		} else {
			throw new Exception("Invalid Data");
		}
	}

	public boolean deleteLocationById(Long locationId) {
		
        Location presentLocation = new Location();
		presentLocation = locationRepository.findLocationById(locationId);
		presentLocation.setActive(false);
		locationRepository.save(presentLocation);
		return true;
	}

}
