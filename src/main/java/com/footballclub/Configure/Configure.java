package com.footballclub.Configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {

	@Bean
	ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
