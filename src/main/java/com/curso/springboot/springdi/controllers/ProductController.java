package com.curso.springboot.springdi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.springdi.models.Product;
import com.curso.springboot.springdi.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	private ProductService service = new ProductService();
	
	@GetMapping("/list")
	public List<Product> list(){
		//ProductService service = new ProductService();
		return service.findAll();
	}

	@GetMapping("/product/{id}")
	public Product product(@PathVariable Long id){
		//ProductService service = new ProductService();
		return service.findById(id);
	}
}
