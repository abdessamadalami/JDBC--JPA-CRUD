package com.springdata.springdatajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public class PlayerRepository {
    @PersistenceContext
    EntityManager entityManager;
    // INSERT
    public Player insertPlayer(Player player)
    {
        return entityManager.merge(player);
    }
    //UPDATE
    public Player updatePlayer(Player player)
    {
        return entityManager.merge(player);
    }
    //FIND
    public Player getPlayerById(int id) {
        return entityManager.find(Player.class, id);
    }

    // delete
    public void deleteById(int id){
        Player player = entityManager.find(Player.class, id);
        entityManager.remove(player);
    }

//   get an list of player Using a named query for SELECT * query (look player classe)#
    public List<Player> getAllPlayers() {
        TypedQuery<Player> getAll = entityManager.createNamedQuery("get_all_players", Player.class);
        return getAll.getResultList();
    }

}
