/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.db.daos;

import com.mti.mtispring.db.entities.People;
import java.util.List;

/**
 *
 * @author collin_t
 */
public class PeopleDAO implements IsDAO<People> {

    @Override
    public void persist(People t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(People t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void merge(People t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<People> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
