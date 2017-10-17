package com.ceiba.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ceiba")
public class MyParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyParkingApplication.class, args);
	}
	
}
