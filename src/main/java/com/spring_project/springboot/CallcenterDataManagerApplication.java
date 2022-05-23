package com.spring_project.springboot;

import com.opencsv.exceptions.CsvException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CallcenterDataManagerApplication {


	public static void main(String[] args) throws IOException, CsvException {
		SpringApplication.run(CallcenterDataManagerApplication.class, args);
	}
// create more tables .... validate input.... test!!
}
