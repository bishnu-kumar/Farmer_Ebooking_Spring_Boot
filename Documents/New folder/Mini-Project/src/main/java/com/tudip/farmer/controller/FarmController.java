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

import com.tudip.entity.Farm;
import com.tudip.serimplementation.FarmServiceImp;

@RestController
public class FarmController {
	@Autowired
	FarmServiceImp farmServiceImp;

	@PostMapping("/createfarm/{locationId}/{userId}")
	Farm save(@RequestBody Farm farm, @PathVariable Long locationId, @PathVariable Long userId) {

		return farmServiceImp.save(farm,locationId,userId);

	}

	@GetMapping("/findallfarm")
	List<Farm> findAll() {
    return farmServiceImp.findAll();
	
	}

	@GetMapping("/findfarmbyid/{farmId}")
	Farm findById(@PathVariable Long farmId) {
		return farmServiceImp.findById(farmId);
	}

	@PutMapping("/updatefarm")
	Farm update(@RequestBody Farm farm) throws Exception {
		return farmServiceImp.update(farm);

	}

	@DeleteMapping("/deletefarmbyid/{farmId}")
	boolean delete(@PathVariable Long farmId) {
		return farmServiceImp.delete(farmId);
	}

}
