package com.medicare.mainApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.medicare.*"})
public class MedicareApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	SpringApplication.run(MedicareApp.class, args);

	}

}
