/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.entities;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author REMI
 */
public class TestManga extends TestCase {

    public TestManga(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(TestManga.class);
    }
    
    public void testFullManga()
    {
        Manga manga = new Manga();
        manga.setId(1);
        manga.setName("name");
        manga.setDescription("description");
        
        Genre genre = new Genre();
        List<Genre> genres = new ArrayList<Genre>();
        genres.add(genre);
        
        Author author = new Author();
        List<Author> authors = new ArrayList<Author>();
        authors.add(author);
        
        Chapter chapter = new Chapter();
        List<Chapter> chapters = new ArrayList<Chapter>();
        chapters.add(chapter);
        
        assertEquals(manga.getId(), 1);
        assertEquals(manga.getName(), "name");
        assertEquals(manga.getDescription(), "description");
        
        assertEquals(manga.getGenres(), null);
        assertEquals(manga.getAuthors(), null);
        assertEquals(manga.getChapters(), null);
        
        manga.setGenres(genres);
        manga.setAuthors(authors);
        manga.setChapters(chapters);
        
        assertEquals(manga.getGenres(), genres);
        assertEquals(manga.getAuthors(), authors);
        assertEquals(manga.getChapters(), chapters);
        
    }
}
