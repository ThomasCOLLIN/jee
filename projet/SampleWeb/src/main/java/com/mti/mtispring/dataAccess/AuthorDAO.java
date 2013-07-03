/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Author;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author collin_t
 */
public class AuthorDAO implements IsDAO<Author> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Author author) {
        entityManager.persist(author);
    }

    @Override
    public void remove(Author author) {
        entityManager.remove(author);
    }

    @Override
    public void merge(Author author) {
        entityManager.remove(author);
    }

    @Override
    public List<Author> findAll() {
        Query query = entityManager.createQuery("SELECT * FROM author");
        return query.getResultList();
    }

    @Override
    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }
    
}
