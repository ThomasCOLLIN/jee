/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Genre;
import java.util.List;
import javax.persistence.Query;

/**
 * Access to the genres table of the database
 * @author collin_t
 */
public class GenreDAO extends DAO<Genre> {

    /**
     * get a list of all the genres
     * @return 
     */
    @Override
    public List<Genre> getAll() {
        Query query = entityManager.createQuery("SELECT g FROM Genre g");
        return query.getResultList();
    }
}
