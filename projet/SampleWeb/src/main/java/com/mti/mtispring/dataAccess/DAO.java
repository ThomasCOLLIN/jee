/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Genre;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author collin_t
 */
public abstract class DAO<T extends Serializable> implements IsDAO<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> clazz;
    
    @Override
    public void persist(T t) {
        entityManager.persist(t);
    }

    @Override
    public void remove(T t) {
        entityManager.remove(t);
    }

    @Override
    public T merge(T t) {
        return entityManager.merge(t);
    }

    @Override
    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public boolean exits(long id) {
        return entityManager.find(clazz, id) != null;
    } 
}
