/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Manga;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author collin_t
 */
public class MangaDAO extends DAO<Manga> {

    @Override
    public List<Manga> getAll() {
        Query query = entityManager.createQuery("SELECT m FROM Manga m");
        return (List<Manga>) query.getResultList();
    }

    public Manga findByName(String name) {
        Query query = entityManager.createQuery("SELECT m FROM Manga m WHERE m.name = " + name);
        return (Manga) query.getSingleResult();
    }

    public List<Manga> findByAuthor(List<String> authors) {
        Query query = entityManager.createQuery("SELECT m FROM Manga m");
        return (List<Manga>) query.getResultList();
    }

    public List<Manga> findByGenre(List<String> genres) {
        Query query = entityManager.createQuery("SELECT m FROM Manga m");
        return (List<Manga>) query.getResultList();
    }
}
