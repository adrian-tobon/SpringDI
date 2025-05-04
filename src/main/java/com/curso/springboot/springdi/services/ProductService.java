package com.curso.springboot.springdi.services;

import java.util.List;

import com.curso.springboot.springdi.models.Product;

public interface ProductService {
	
	List<Product> findAll();
	Product findById(Long id);

}
