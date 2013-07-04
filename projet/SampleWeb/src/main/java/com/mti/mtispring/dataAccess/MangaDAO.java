/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Manga;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

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
    
    @Override
    public Manga findById(long id){
        Query query;
        query = entityManager.createQuery("SELECT m FROM Manga m WHERE m.id LIKE :mangaId")
                             .setParameter("mangaId", id);
                
        return (Manga) query.getSingleResult();
    }
    
    public List<Manga> findByName(String name) {
        name = "%" + name + "%";
        Query query = entityManager.createQuery("SELECT m FROM Manga m WHERE m.name LIKE :name")
                .setParameter("name", name);
        return (List<Manga>) query.getResultList();
    }

    public List<Manga> findByAuthor(List<String> authors) {
        Query query = entityManager.createQuery("SELECT m FROM Manga m JOIN m.authors a WHERE a.lastname IN (:authors) GROUP BY m.id")
                .setParameter("authors", authors);
        return (List<Manga>) query.getResultList();
    }

    public List<Manga> findByGenre(List<String> genres) {
        Query query = entityManager.createQuery("SELECT m FROM Manga m JOIN m.genres g WHERE g.name IN (:genres) GROUP BY m.id")
                .setParameter("genres", genres);
        return (List<Manga>) query.getResultList();
    }
}
