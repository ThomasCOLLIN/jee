/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.db.daos;

import com.mti.mtispring.db.entities.People;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author collin_t
 */
public class PeopleDAO implements IsDAO<People> 
{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void persist(People t) 
    {
//        emf.persist(t);
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(People t) 
    {
//        entityManager.remove(t);
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void merge(People t) 
    {
//        entityManager.merge(t);
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<People> findAll() 
    {
        
        Query res = entityManager.createQuery("SELECT * FROM PEOPLE");
        List<People> lRes = res.getResultList();
        return lRes;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<People> findByLogin(String login) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
