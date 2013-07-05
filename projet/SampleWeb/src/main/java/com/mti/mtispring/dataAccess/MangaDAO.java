/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Manga;
import java.util.List;
import javax.persistence.Query;

/**
 * Access to the mangas table of the database
 * @author collin_t
 */
public class MangaDAO extends DAO<Manga> {
    /**
     * @return all the mangas present in the database
     */
    @Override
    public List<Manga> getAll() {
        Query query = entityManager.createQuery("SELECT m FROM Manga m");
        return (List<Manga>) query.getResultList();
    }
    
    /**
     * get the manga with the corresponding id
     * @param id the id of the manga
     * @return the manga or null if it doesn't exist
     */
    @Override
    public Manga findById(long id){
        Query query;
        query = entityManager.createQuery("SELECT m FROM Manga m WHERE m.id LIKE :mangaId")
                             .setParameter("mangaId", id);
                
        return (Manga) query.getSingleResult();
    }
    
    /**
     * get a list of manga with the corresponding name
     * @param name name to match
     * @return the manga matching the name
     */
    public List<Manga> findByName(String name) {
        name = "%" + name + "%";
        Query query = entityManager.createQuery("SELECT m FROM Manga m WHERE m.name LIKE :name")
                .setParameter("name", name);
        return (List<Manga>) query.getResultList();
    }

    /**
     * get a list of mangas that are matching at leat one author in the list
     * @param authors a list of authors
     * @return a list of matching mangas
     */
    public List<Manga> findByAuthor(List<String> authors) {
        Query query = entityManager.createQuery("SELECT m FROM Manga m JOIN m.authors a WHERE a.lastname IN (:authors) GROUP BY m.id")
                .setParameter("authors", authors);
        return (List<Manga>) query.getResultList();
    }

    /**
     * get a list of mangas that are matching at leat one genre in the list
     * @param genres a list of genres
     * @return a list of matching mangas
     */
    public List<Manga> findByGenre(List<String> genres) {
        Query query = entityManager.createQuery("SELECT m FROM Manga m JOIN m.genres g WHERE g.name IN (:genres) GROUP BY m.id")
                .setParameter("genres", genres);
        return (List<Manga>) query.getResultList();
    }
}
