package com.curso.springboot.springdi;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({	
	@PropertySource(value="classpath:config/app.properties", encoding="UTF-8")
})
public class SpringDIConfig {

}
