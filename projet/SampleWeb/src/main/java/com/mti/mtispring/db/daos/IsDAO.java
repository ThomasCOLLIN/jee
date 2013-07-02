/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.db.daos;

import java.io.Serializable;
import java.util.List;
/**
 *
 * @author collin_t
 */
public  interface IsDAO<T extends Serializable> {
    /**
     * create an entity in the db
     * @param e
     */
    public void persist(T t);

    /**
     * remove an entity from the db
     * @param e 
     */
    public void remove(T t);

    /**
     * update an entity from the db
     * @param e 
     */
    public void merge(T t);
    
    /**
     * retrieve the entities from the db
     */
    public List<T> findAll();
    
    /**
     * retrieve one entity with the good Id
     * @param id
     * @return 
     */
    public T findById(long id);

}
