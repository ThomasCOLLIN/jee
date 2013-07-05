/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import java.io.Serializable;
import java.util.List;
/**
 * an interface containing the basic access function to access a database  using a javax.persistence.EntityManager
 * @author collin_t
 */
public  interface IsDAO<T extends Serializable> {
    /**
     * create an entity in the db
     * @param t the entity
     */
    public void persist(T t);

    /**
     * remove an entity from the db
     * @param t then entity
     */
    public void remove(T t);

    /**
     * update an entity from the db
     * @param t the entity
     * @return another entity equals to the one saved
     */
    public T merge(T t);
    
    /**
     * retrieve one entity with the good Id
     * @param id the id of the entity
     * @return the entity
     */
    public T findById(long id);

    /**
     * 
     * @return all the entities of type T
     */
    public List<T> getAll();
    
    /**
     * check if an entity exists
     * @param id of the entity
     * @return 
     */
    boolean exits(long id);
}
