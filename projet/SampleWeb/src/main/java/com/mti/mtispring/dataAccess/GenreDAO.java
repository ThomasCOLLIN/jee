/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Genre;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author collin_t
 */
public class GenreDAO implements IsDAO<Genre> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Genre genre) {
        entityManager.persist(genre);
    }

    @Override
    public void remove(Genre genre) {
        entityManager.remove(genre);
    }

    @Override
    public void merge(Genre genre) {
        entityManager.merge(genre);
    }

    @Override
    public List<Genre> findAll() {
        Query query = entityManager.createQuery("SELECT * FROM genre");
        return query.getResultList();
    }

    @Override
    public Genre findById(long id) {
        return entityManager.find(Genre.class, id);
    }
}
