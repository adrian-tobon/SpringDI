package com.curso.springboot.springdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.curso.springboot.springdi.models.Product;
import com.curso.springboot.springdi.repositories.ProductRepository;

public class ProductService {
	
	
	private ProductRepository repository = new ProductRepository();
	
	public List<Product> findAll(){

	return repository.findAll().stream().map(p -> {
			Double priceImp = p.getPrice() *1.19d;
			Product product = new Product(p.getId(), p.getName(), priceImp.longValue());
			//p.setPrice(priceImp.longValue());			
			return product;
		}).collect(Collectors.toList());	
		
	}
	
	public Product findById(Long id)
	{
		return repository.findById(id);
	}	

}
