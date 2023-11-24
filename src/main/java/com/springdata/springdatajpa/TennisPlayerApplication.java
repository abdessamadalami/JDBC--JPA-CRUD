package com.springdata.springdatajpa;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {
    @Autowired
    PlayerRepository repo;
    @Autowired
    PlayerSpringDataRepository repo1;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      /*  logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
                new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));


        logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
                new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));

        logger.info("\n\n>> Player with id 2: {}\n", repo.getPlayerById(2));
        //update player
        logger.info("\n\n>> Updating Player with Id 3: {}\n", repo.updatePlayer(
                new Player(3, "ALAMO", "Austria", Date.valueOf("1993-09-03"), 17)));

        //get player
        logger.info("\n\n>> Player with id 3: {}\n", repo.getPlayerById(3));
        repo.deleteById(2);
        //
            logger.info("All Players Data: {}", repo.getAllPlayers());*/

        // Spring data JPA MORE THAN powerful
        logger.info("\n\n>>Inserting Player: {}\n", repo1.save(new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
        logger.info("\n\n>>Inserting Player: {}\n", repo1.save(new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));
        logger.info("\n\n>>Inserting Player: {}\n", repo1.save(new Player("Thiem", "Austria", new Date(System.currentTimeMillis()), 17)));
        logger.info("\n\n>>Updating Player with Id 3: {}\n", repo1.save(new Player(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));
        logger.info("\n\n>>Player with Id 2: {}\n", repo1.findById(2));
        repo1.deleteById(2);
        logger.info("\n\n>>All Players Data: {}\n", repo1.findAll());
        logger.info("\n\n>>All Players hava this nationality: {}\n", repo1.findByNationality("Morocco")); // no one empty list

    }

}
