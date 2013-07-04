package com.mti.mtispring.businessManagament;

import com.mti.mtispring.dataAccess.MangaDAO;
import com.mti.mtispring.entities.*;
import java.util.List;

public class MangaManager {

    private MangaDAO mangaDao;

    public MangaManager(MangaDAO mangaDao) {
        this.mangaDao = mangaDao;
    }
    
    
    public MangaList getAllManga() {
        return new MangaList(mangaDao.getAll());
    }

    public Manga getManga(long id) {
        return mangaDao.findById(id);
    }

    public Manga getMangaByName(String name) {
        return mangaDao.findByName(name);
    }

    public MangaList getMangaByAuthors(List<String> authors) {
        return new MangaList(mangaDao.findByAuthor(authors));
    }

    public MangaList getMangaByGenre(List<String> genres) {
        return new MangaList(mangaDao.findByGenre(genres));
    }
}