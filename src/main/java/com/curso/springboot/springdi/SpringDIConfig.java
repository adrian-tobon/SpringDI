package com.curso.springboot.springdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;

import com.curso.springboot.springdi.repositories.ProductRepository;
import com.curso.springboot.springdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({	
	@PropertySource(value="classpath:config/app.properties", encoding="UTF-8")
})
public class SpringDIConfig {
	
	@Value("classpath:json/product.json")
	private Resource resource;
	
	/*@Bean("productJson")
	//@Primary
	public ProductRepository productRepositoryJson() {
		return new ProductRepositoryJson();
	}*/
	
	//@Primary
	@Bean("productJson")
	public ProductRepository productRepositoryJson() {
		return new ProductRepositoryJson(resource);
	}

}
