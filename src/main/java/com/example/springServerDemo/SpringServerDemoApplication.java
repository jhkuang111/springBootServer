package com.example.springServerDemo;

import java.sql.Date;
import java.util.HashSet;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringServerDemoApplication {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlayerDao dao;

	@Autowired
	CompetitorRepository repo;

	@Autowired
	CompetitorSpringDataRepository springDataRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringServerDemoApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {

	}
	*/

}
