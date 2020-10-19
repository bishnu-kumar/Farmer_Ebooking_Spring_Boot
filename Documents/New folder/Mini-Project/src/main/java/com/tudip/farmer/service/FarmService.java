package com.tudip.farmer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tudip.entity.Farm;

@Service
public interface FarmService {
	
	Farm save(Farm farm);
	List<Farm> findAll();
	Farm findById(Long farmId);
	Farm update(Farm farm);
	boolean delete(Long farmId);
}
