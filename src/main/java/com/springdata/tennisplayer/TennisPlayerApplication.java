package com.springdata.tennisplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {
	@Autowired
	PlayerDao dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		logger.info("All Players Data: {}", dao.getAllPlayers());
		logger.info("All Players Data: {}", dao.getById(1));
	}

}
