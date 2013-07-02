/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.People;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author collin_t
 */
public class PeopleDAO implements IsDAO<People> 
{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void persist(People people) 
    {
        entityManager.persist(people);
    }

    @Override
    public void remove(People people) 
    {
        entityManager.remove(people);
    }

    @Override
    public void merge(People people) 
    {
        entityManager.merge(people);
    }

    @Override
    public List<People> findAll() 
    {  
        Query res = entityManager.createQuery("select p from People p");
        List<People> lRes = res.getResultList();
        return lRes;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public People findById(long id) 
    {
        return entityManager.find(People.class, id);
    }
    
}
