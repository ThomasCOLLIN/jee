package com.mti.mtispring.businessManagament;

import com.mti.mtispring.entities.*;
import java.util.List;

public class MangaManager {
    
    private MangaDao mangaDao = new MangaDao();
    
    public MangaList getAllManga() {
        /*List<Manga> mangas = new ArrayList<Manga>();
        Chapter chap = new Chapter();
        chap.setId(0);
        chap.setMangaId(0);
        chap.setFilePath("random");                
        Manga test = new Manga();
        test.setId(0);
        test.setName("test");
        test.setDescription("test est un manga de merde");
        test.addChapter(chap);
        mangas.add(test);
        mangas.add(test);
        MangaList list = new MangaList(mangas);*/

        return new MangaList(mangaDao.findAll());
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

    public List<Manga> getMangaByBoth(List<String> authors, List<String> genres)
    {
        return mangaDao.findByAuthorAndGenre(authors, genres);
    }
}