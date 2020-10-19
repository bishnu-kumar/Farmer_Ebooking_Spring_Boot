package com.tudip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.tudip.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select u from Product u where u.productId=?1 and active=true")
	Product findProductById(Long ProductId);

}
