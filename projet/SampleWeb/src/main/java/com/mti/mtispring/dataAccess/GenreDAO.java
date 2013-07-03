/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Genre;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author collin_t
 */
public class GenreDAO extends DAO<Genre> {
    @Override
    public List<Genre> getAll() {
        Query query = entityManager.createQuery("SELECT g FROM Genre g");
        return query.getResultList();
    }
}
