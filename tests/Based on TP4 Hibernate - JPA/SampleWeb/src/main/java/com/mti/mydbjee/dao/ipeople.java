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
public interface ipeople {
    void persist(People p);
    void remove(People p);
    void merge(People p);
    Collection<People> findAll();
    Collection<People> findByLogin(String login);
}
