package com.mappings.cruddemo.dao;

import com.mappings.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class AppDAOImpl implements AppDAO {

    // define field for entity manager.
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public AppDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }
}
