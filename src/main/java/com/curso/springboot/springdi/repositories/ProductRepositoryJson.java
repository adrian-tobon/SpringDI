package com.curso.springboot.springdi.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import com.curso.springboot.springdi.models.Product;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ProductRepositoryJson implements ProductRepository {
	
	private List<Product> list;
	

	public ProductRepositoryJson() {
		Resource resource = new ClassPathResource("json/product.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = Arrays.asList(mapper.readValue(resource.getFile(), Product[].class));
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> findAll() {
		
		return list;
	}

	@Override
	public Product findById(Long id) {		
		return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}

}
