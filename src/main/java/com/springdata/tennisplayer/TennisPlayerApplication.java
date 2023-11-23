package com.springdata.tennisplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Date;
@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {
	@Autowired
	PlayerDao dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
		System.gc(); // free
	}
	@Override
	public void run(String... args) throws Exception {
		logger.info("Inserting Player 4: {}", dao.insertPlayer(
				new Player(4, "Thiem", "Morocco",
						new Date(System.currentTimeMillis()),
						17)));
		logger.info("All Players Data: {}", dao.getAllPlayers());

		logger.info("Updating Player with Id 4: {}",  dao.updatePlayer(
				new Player(4, "Thiem", "Austria",
						Date.valueOf("1993-09-03"), 17)));
		logger.info("All Players Data: {}", dao.getAllPlayers());

		logger.info("Deleting Player with Id 2: {}", dao.deletePlayerById(2));
		logger.info("All Players Data: {}", dao.getAllPlayers());

		dao.createTournamentTable();
		logger.info(" get player Nationality {}", dao.getPlayerByNationality("USA"));
	}
}
