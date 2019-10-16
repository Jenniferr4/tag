package org.improving.tag.database;

import org.improving.tag.Location;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class LocationDAO {
    private final JdbcTemplate jdbcTemplate;
    public LocationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Location> findAll() {
        try {
            EntityManager em = JPAUtility.getEntityManager();
            List<Location> locations =
                    em.createQuery("SELECT loc FROM org.improving.tag.Location loc").getResultList();
            return locations;

        } catch (
                DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }
}

