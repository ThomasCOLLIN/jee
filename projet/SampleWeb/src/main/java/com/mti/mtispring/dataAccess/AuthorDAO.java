/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Author;
import java.util.List;
import javax.persistence.Query;

/**
 * Access to the authors table of the database
 * @author collin_t
 */
public class AuthorDAO extends DAO<Author> {

    /**
     * get a list of all the authors
     * @return 
     */
    @Override
    public List<Author> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM author a");
        return query.getResultList();
    }
}
