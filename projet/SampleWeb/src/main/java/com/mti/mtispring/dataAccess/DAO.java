/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * an abstract class implementing all the basic accesses to the database
 * @author collin_t
 */
public abstract class DAO<T extends Serializable> implements IsDAO<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> clazz;
    
    /**
     * Save an entity to the database. Modifying the entity afterward will update it
     * @param t the entity to save
     */
    @Override
    public void persist(T t) {
        entityManager.persist(t);
    }

    /**
     * Remove an entity from the database
     * @param t the entity to remove
     */
    @Override
    public void remove(T t) {
        entityManager.remove(t);
    }

    /**
     * Save an entity to the database.  Modifying the entity afterward will update it. However, modifying the returned entity will update it.
     * @param t
     * @return 
     */
    @Override
    public T merge(T t) {
        return entityManager.merge(t);
    }

    /**
     * Find an entity from its identifier. Identifiers are unique for a kind of entity.
     * @param id the identifier
     * @return the entity
     */
    @Override
    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    /**
     * Check if an entity exists in the database
     * @param id id of the entity
     * @return true if it exists, else false
     */
    @Override
    public boolean exits(long id) {
        return entityManager.find(clazz, id) != null;
    } 
}
