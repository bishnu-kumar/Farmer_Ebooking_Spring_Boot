package com.tudip.serimplementation;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudip.entity.Farm;
import com.tudip.entity.Product;
import com.tudip.repository.ProductRepository;

@Service
public class ProductServiceImp {
	@Autowired
	ProductRepository productRepository;

	public Product findById(Long productId) throws Exception {
		if(productRepository.findProductById(productId)!=null) {
		return productRepository.findProductById(productId);
		}
		else {
			throw new Exception("Product Not Found ");
		}
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product save(Product product) {
		product.setActive(true);
		product.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		return productRepository.save(product);
	}

	public Product update(Product product) throws Exception {
		
		
		Product present = new Product();
		 present = productRepository.findProductById(product.getProductId());
		 if(present!=null) {
		  present.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
		  present.setProductName(product.getProductName());
		  present.setPrice(product.getPrice());
		  present.setProductDetail(product.getProductDetail());
		  return productRepository.save(present); 
		 }
		 else {
			 throw new Exception("Noa a valid data");
		 }
	
		
		
	}

	public boolean delete(Long productId) throws Exception {
        if(productRepository.existsById(productId)) { 
        	Product product = new Product();
        	product = productRepository.findProductById(productId);
        	product.setActive(false);
        	productRepository.save(product);
        	
		    return true;
        }
        else {
        	throw new Exception("User Not Found"); 
        }
	}

}
