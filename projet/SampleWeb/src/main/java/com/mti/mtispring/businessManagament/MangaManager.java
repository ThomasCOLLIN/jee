package com.mti.mtispring.businessManagament;

import com.mti.mtispring.dataAccess.MangaDAO;
import com.mti.mtispring.entities.*;
import java.util.List;

/**
 * manage mangas retrieved from the database
 */
public class MangaManager {

    private MangaDAO mangaDao;

    public MangaManager(MangaDAO mangaDao) {
        this.mangaDao = mangaDao;
    }
    

    /**
    * retrieve a list containing all mangas
    */
    public MangaList getAllManga() {
        return new MangaList(mangaDao.getAll());
    }

    /**
     * get a manga from its id
     */
    public Manga getManga(long id) {
        return mangaDao.findById(id);
    }

    /**
     * get a list of mangas coresponding to a mail
     */
    public MangaList getMangaByName(String name) {
        return new MangaList(mangaDao.findByName(name));
    }

    /**
     * get a list of mangas matching one of the authors
     */
    public MangaList getMangaByAuthors(List<String> authors) {
        return new MangaList(mangaDao.findByAuthor(authors));
    }

    /**
     * get a list of mangas matching one of the genre
     */
    public MangaList getMangaByGenre(List<String> genres) {
        return new MangaList(mangaDao.findByGenre(genres));
    }
}