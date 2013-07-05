/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Chapter;
import java.util.List;
import javax.persistence.Query;

/**
 * Access to the chapters table of the database
 * @author collin_t
 */
public class ChapterDAO extends DAO<Chapter> {

    /**
     * @deprecated
     * @return a list of all chapter
     */
    @Override
    public List<Chapter> getAll() {
        Query query = entityManager.createQuery("SELECT c FROM Chapter c");
        return query.getResultList();
    }

    /**
     * get all the chapters of a manga
     *
     * @param mangaId id of the manga
     * @return a list of chapter
     */
    public List<Chapter> findByMangaId(long mangaId) {
        Query query = entityManager.createQuery("SELECT c FROM Chapter c WHERE c.mangaId LIKE :mangaId")
                .setParameter("mangaId", mangaId);
        return (List<Chapter>) query.getResultList();
    }

    /**
     * get a list of the chapter from a manga
     * @param mangaId id of the manga
     * @param chaptersId ids of the chapters
     * @return a list of chapter containing only the ones found
     */
    public List<Chapter> findByMangaId(Long mangaId, List<Long> chaptersId) {
        Query query = entityManager.createQuery("SELECT c FROM Chapter c WHERE c.id IN (:chaptersId) AND c.mangaId LIKE :mangaId")
                .setParameter("chaptersId", chaptersId)
                .setParameter("mangaId", mangaId);
        return (List<Chapter>) query.getResultList();
    }
}
