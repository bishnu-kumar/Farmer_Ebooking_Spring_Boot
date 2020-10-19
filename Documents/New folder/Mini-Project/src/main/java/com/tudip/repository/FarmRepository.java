package com.tudip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tudip.entity.Farm;
@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    @Query("select u from Farm u where u.farmId=?1")
	Farm findFarmBYId(Long farmId);
    
   // @Query("select u from Farm u where u.farmId=?1")
   // Farm getDateById(Long farmId);
	
	

}
