package com.example.ProyectoClonicaOdontologica1;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.mapping.Property;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class ProyectoClonicaOdontologica1Application {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");

		SpringApplication.run(ProyectoClonicaOdontologica1Application.class, args);
	}

}
