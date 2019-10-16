package org.improving.tag.database;

import org.improving.tag.Exit;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ExitsDAO {

    private final JdbcTemplate jdbcTemplate;

    public ExitsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Exit> findByOriginId(int originId) {
        try {
            EntityManager em = JPAUtility.getEntityManager();
            List<Exit> exits =
                    em.createQuery("SELECT loc FROM org.improving.tag.Exit loc").getResultList();
            return exits;

        } catch (
                DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }
}