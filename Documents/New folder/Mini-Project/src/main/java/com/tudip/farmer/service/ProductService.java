package com.tudip.farmer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tudip.entity.Product;

@Service
public interface ProductService {

	Product findById(Long productId);

	List<Product> findAll();

	Product save(Product product);

	Product update(Product product);

	boolean delete(Long productId);

}
