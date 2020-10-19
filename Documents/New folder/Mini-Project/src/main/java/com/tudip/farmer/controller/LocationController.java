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

import com.tudip.entity.Location;
import com.tudip.serimplementation.LocationServiceImp;

@RestController
public class LocationController {
	@Autowired
	LocationServiceImp locationServiceImp;

	@PostMapping("/addlocation")
	Location save(@RequestBody Location location) {
		return locationServiceImp.save(location);

	}

	@GetMapping("/findalllocation")
	List<Location> findAll() {
		return locationServiceImp.findAll();
	}

	@GetMapping("/findlocationbyid/{locationId}")
	Location findLocationById(@PathVariable Long locationId) {
		return locationServiceImp.findLocationById(locationId);
	}

	@PutMapping("/updatelocation")
	Location updateLocation(@RequestBody Location location) throws Exception {
		return locationServiceImp.updateLocation(location);
	}

	@DeleteMapping("/deletelocationbyid/{locationId}")
	boolean deleteLocationById(@PathVariable Long locationId) {
		return locationServiceImp.deleteLocationById(locationId);
	}

}
