/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mydbjee.dao;

import com.mti.mydbjee.People;
import java.util.Collection;

/**
 *
 * @author REMI
 */
public class people implements ipeople
{

    @Override
    public void persist(People p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(People p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void merge(People p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<People> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<People> findByLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
