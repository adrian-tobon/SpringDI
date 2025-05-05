package com.curso.springboot.springdi.repositories;

import java.util.Collections;
import java.util.List;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.curso.springboot.springdi.models.Product;

//@Primary
@Repository("foo")
public class ProductRepositoryFoo implements ProductRepository{

	@Override
	public List<Product> findAll() {
		
		return Collections.singletonList(new Product(1L,"Monitor ASUS 27", 600L));
	}

	@Override
	public Product findById(Long id) {
	
		return new Product(id,"Monitor ASUS 27", 600L);
	}

}
