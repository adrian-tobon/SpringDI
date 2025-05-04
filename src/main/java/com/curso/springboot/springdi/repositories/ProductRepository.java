package com.curso.springboot.springdi.repositories;

import java.util.List;

import com.curso.springboot.springdi.models.Product;

public interface ProductRepository {
	
	List<Product> findAll();
	Product findById(Long id);

}
