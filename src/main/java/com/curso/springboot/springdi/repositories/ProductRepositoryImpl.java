package com.curso.springboot.springdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

import com.curso.springboot.springdi.models.Product;

//normalmente esta clase es para acceso a una DB

//@Component
@Primary
@Repository
//@RequestScope
//@SessionScope
public class ProductRepositoryImpl implements ProductRepository {

	private List<Product> data;

	public ProductRepositoryImpl() {

		this.data = Arrays.asList(new Product(1L, "Memoria Corsair 32", 300L),
				new Product(2L, "CPU Intel Core i9", 850L), new Product(3L, "Teclado Razer Mini 60%", 180L),
				new Product(4L, "Motherboard Gigabyte", 490L));

	}

	@Override
	public List<Product> findAll() {
		return data;
	}

	@Override
	public Product findById(Long id) {
		return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}

}
