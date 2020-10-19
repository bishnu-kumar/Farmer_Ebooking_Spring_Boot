package com.tudip.serimplementation;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudip.entity.Farm;
import com.tudip.repository.FarmRepository;
import com.tudip.repository.UserRepository;
@Service
public class FarmServiceImp {

	@Autowired
	FarmRepository farmRepository;
	@Autowired 
	private LocationServiceImp locationServiceImp;
	@Autowired
	private UserRepository userRepository;
	
	public Farm save(Farm farm, Long locationId, Long userId) {
		farm.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		
		farm.setLocation(locationServiceImp.findLocationById(locationId));
		farm.setUser(userRepository.findFarmerById(userId));
		farm.setActive(true);
		return farmRepository.save(farm);

	}

	public List<Farm> findAll() {

		return farmRepository.findAll();
	}

	public Farm findById(Long farmId) {

		return farmRepository.findFarmBYId(farmId);
	}

	public Farm update(Farm farm) throws Exception {
		
		Farm farm1 = new Farm();
	   farm1= farmRepository.findFarmBYId(farm.getFarmId());
	   if(farm1!=null) {
		farm1.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		farm1.setSoilType(farm.getSoilType());
		farm1.setCrop(farm.getCrop());
		return farmRepository.save(farm1);
	   }
	   else 
		    throw new Exception("Invalid Data");
	   
	}
	

	public boolean delete(Long farmId) {
		farmRepository.deleteById(farmId);
		return true;
	}

}
