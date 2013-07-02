/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Manga;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author collin_t
 */
public class MangaDAO implements IsDAO<Manga> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Manga manga) {
        entityManager.persist(manga);
    }

    @Override
    public void remove(Manga manga) {
        entityManager.remove(manga);
    }

    @Override
    public void merge(Manga manga) {
        entityManager.merge(manga);
    }

    @Override
    public List<Manga> findAll() {
        Query query = entityManager.createQuery("SELECT * FROM manga");
        return query.getResultList();
    }

    @Override
    public Manga findById(long id) {
        return entityManager.find(Manga.class, id);
    }
}
