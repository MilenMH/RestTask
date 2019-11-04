package com.rest.task.demo;

import com.rest.task.demo.interceptors.RESTExceptionHandler;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.HandlerExceptionResolver;

@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication {

	@Bean
	HandlerExceptionResolver customExceptionResolver () {
		return new RESTExceptionHandler();
	}

	@Bean
	public ModelMapper createMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
