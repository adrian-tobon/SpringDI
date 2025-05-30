package com.curso.springboot.springdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.springboot.springdi.models.Product;
import com.curso.springboot.springdi.repositories.ProductRepository;

//@Component
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	//@Qualifier("foo")
	@Qualifier("productJson")
	private ProductRepository repository;
	
	@Value("${values.tax}")
	private Double Iva;
	
	/*public ProductServiceImpl(@Qualifier("foo") ProductRepository repository) {
		super();
		this.repository = repository;
	}*/

	@Override
	public List<Product> findAll(){

	return repository.findAll().stream().map(p -> {
		
			Double priceIva = p.getPrice() * Iva;
			Product product = (Product)p.clone();
			product.setPrice(priceIva.longValue());
			//p.setPrice(priceIva.longValue());
			return product;
			//return p;
			
		}).collect(Collectors.toList());	
		
	}
	
	@Override
	public Product findById(Long id)
	{
		return repository.findById(id);
	}	

}
