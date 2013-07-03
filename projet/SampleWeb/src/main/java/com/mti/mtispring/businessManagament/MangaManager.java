package com.mti.mtispring.businessManagament;

import com.mti.mtispring.dataAccess.MangaDAO;
import com.mti.mtispring.entities.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class MangaManager {
    @Autowired
    private MangaDAO mangaDao;
    
    public MangaList getAllManga() {
        return new MangaList(mangaDao.getAll());
    }

    public Manga getManga(long id) {
        return mangaDao.findById(id);
    }

    public Manga getMangaByName(String name) {
        return mangaDao.findByName(name);
    }

    public List<Manga> getMangaByAuthors(List<String> authors) {
        return mangaDao.findByAuthor(authors);
    }

    public List<Manga> getMangaByGenre(List<String> genres) {
        return mangaDao.findByGenre(genres);
    }
}