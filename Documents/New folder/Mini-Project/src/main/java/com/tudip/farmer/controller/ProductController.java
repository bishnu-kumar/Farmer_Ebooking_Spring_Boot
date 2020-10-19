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
import com.tudip.entity.Product;
import com.tudip.serimplementation.ProductServiceImp;
@RestController
public class ProductController {
	
	@Autowired
	ProductServiceImp productServiceImp;

	@PostMapping("/addproduct")
	Product save(@RequestBody Product product) {
		

		return productServiceImp.save(product);

	}

	@GetMapping("/findallproduct")
	List<Product> findAll() {
    return productServiceImp.findAll();
	
	}
   
	@GetMapping("/findproductbyid/{productId}")
	Product findProductById(@PathVariable Long productId) throws Exception {
		return productServiceImp.findById(productId);
	}

	@PutMapping("/updateproduct")
	Product update(@RequestBody Product product) throws Exception  {
		return productServiceImp.update(product);

	}

	@DeleteMapping("/deleteproductbyid/{productId}")
	boolean delete(@PathVariable Long  productId) throws Exception {
		return productServiceImp.delete(productId);
	}

	
	
	
	
	
	
	
	
	

}
