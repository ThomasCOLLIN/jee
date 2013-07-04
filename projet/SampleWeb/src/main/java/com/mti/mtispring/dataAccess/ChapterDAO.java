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
     *
     * @param mangaId id of the manga
     * @return a list of chapter
     */
    public List<Chapter> findAll(long mangaId) {
        Query query = entityManager.createQuery("SELECT c FROM Chapter c WHERE c.mangaId LIKE :mangaId")
                                   .setParameter("mangaId", mangaId);
        return query.getResultList();
    }

    @Override
    public List<Chapter> getAll() {
        Query query = entityManager.createQuery("SELECT c FROM Chapter c");
        return query.getResultList();
    }

    public List<Chapter> findByMangaId(long mangaId) {
        Query query = entityManager.createQuery("SELECT c FROM Chapter c WHERE c.mangaId LIKE :mangaId")
                                    .setParameter("mangaId", mangaId);
        return (List<Chapter>) query.getResultList();
    }

    public List<Chapter> findByMangaId(Long mangaId, List<Long> chaptersId) {
//        String inString = "";
//        for (int i = 0; i < chaptersId.size(); i++) {
//            if (i == 0) {
//                inString = inString + "'" + chaptersId.get(i).toString() + "'";
//            } else {
//                inString = inString + ",'" + chaptersId.get(i).toString() + "'";
//            }
//        }
        
        Query query = entityManager.createQuery("SELECT c FROM Chapter c WHERE c.id IN (:chaptersId) AND c.mangaId LIKE :mangaId")
                                    .setParameter("chaptersId", chaptersId)
                                    .setParameter("mangaId", mangaId);
        return (List<Chapter>) query.getResultList();
    }
}
