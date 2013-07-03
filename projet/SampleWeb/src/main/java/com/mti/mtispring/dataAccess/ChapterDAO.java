/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Chapter;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author collin_t
 */
public class ChapterDAO extends DAO<Chapter> {

    /**
     * get all chapter of a manga
     * @param mangaId id of the manga
     * @return a list of chapter
     */
    public List<Chapter> findAll(long mangaId) {
        Query query = entityManager.createQuery("SELECT c FROM Chapter c WHERE c.mangaId = " + mangaId);
        return query.getResultList();
    }

    @Override
    public List<Chapter> getAll() {
        Query query = entityManager.createQuery("SELECT c FROM Chapter c");
        return query.getResultList();
    }
}
