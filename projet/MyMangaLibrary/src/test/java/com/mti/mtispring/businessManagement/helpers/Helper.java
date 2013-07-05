/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.businessManagement.helpers;

import com.mti.mtispring.dataAccess.AuthorDAO;
import com.mti.mtispring.dataAccess.ChapterDAO;
import com.mti.mtispring.dataAccess.GenreDAO;
import com.mti.mtispring.dataAccess.MangaDAO;
import com.mti.mtispring.entities.Author;
import com.mti.mtispring.entities.Chapter;
import com.mti.mtispring.entities.Genre;
import com.mti.mtispring.entities.Manga;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author REMI
 */
public class Helper {

    private MangaDAO mangaDAO;
    private ChapterDAO chapterDAO;
    private GenreDAO genreDAO;
    private AuthorDAO authorDAO;
    
    public Helper(MangaDAO mangaDAO, ChapterDAO chapterDAO, GenreDAO genreDAO, AuthorDAO authorDAO)
    {
        this.mangaDAO = mangaDAO;
        this.chapterDAO = chapterDAO;
        this.genreDAO = genreDAO;
        this.authorDAO = authorDAO;
    }
    public void insertDatasInBBD()
    {
        Genre genre = new Genre();
        genre.setName("TestGenre");
        List<Genre> genres = new ArrayList<Genre>();
        genres.add(genre);
        
        Author author = new Author();
        author.setFirstname("TestFirstname");
        author.setLastname("TestLastname");
        author.setType("TestType");
        List<Author> authors = new ArrayList<Author>();
        authors.add(author);
               
        Chapter chapter = new Chapter();
        chapter.setNumber(42);
        //chapter.setMangaId(manga.getId());
        chapter.setFilePath("http://filepath.com");
         List<Chapter> chapters = new ArrayList<Chapter>();
        chapters.add(chapter);       
        
        Manga manga = new Manga();
        manga.setName("TestName");
        manga.setDescription("TestDescription");
        
        manga.setGenres(genres);
        manga.setAuthors(authors);
        manga.setChapters(chapters);
        
        mangaDAO.persist(manga);

    }
}
