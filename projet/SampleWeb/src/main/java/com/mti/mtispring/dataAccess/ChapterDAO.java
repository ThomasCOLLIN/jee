/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Chapter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author collin_t
 */
public class ChapterDAO implements IsDAO<Chapter> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Chapter chapter) {
        entityManager.persist(chapter);
    }

    @Override
    public void remove(Chapter chapter) {
        entityManager.remove(chapter);
    }

    @Override
    public void merge(Chapter chapter) {
        entityManager.merge(chapter);
    }

    @Override
    public List<Chapter> findAll() {
        Query query = entityManager.createQuery("SELECT * FROM author");
        return query.getResultList();
    }

    @Override
    public Chapter findById(long id) {
        return entityManager.find(Chapter.class, id);
    }
}
