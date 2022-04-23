package com.example.elearning;

import java.util.Arrays;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@ComponentScan({ "com.example.elearning.*" })
public class ProjetELearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetELearningApplication.class, args);
		
	}
	

}
