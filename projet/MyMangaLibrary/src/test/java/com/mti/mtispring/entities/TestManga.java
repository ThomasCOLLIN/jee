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
    
    public void testNull()
    {
        Manga manga = new Manga();
        assertNotNull(manga);
    }
    
    public void testId(){
        Manga manga = new Manga();
        manga.setId(1);
        assertEquals(manga.getId(), 1);
    }
    
    public void testName(){
        Manga manga = new Manga();
        manga.setName("name");
        assertEquals(manga.getName(), "name");
    }
    
    public void testDescription()
    {
        Manga manga = new Manga();
        manga.setDescription("description");
        assertEquals(manga.getDescription(), "description");
    }
    
    public void testGenre()
    {
        Manga manga = new Manga();
        Genre genre = new Genre();
        List<Genre> genres = new ArrayList<Genre>();
        genres.add(genre);
        manga.setGenres(genres);
        assertEquals(manga.getGenres(), genres);
    }
    
    public void testAuthor()
    {
        Manga manga = new Manga();
        Author author = new Author();
        List<Author> authors = new ArrayList<Author>();
        authors.add(author);
        manga.setAuthors(authors);
        assertEquals(manga.getAuthors(), authors);
    }
    
    public void testChapter()
    {
        Manga manga = new Manga();
        Chapter chapter = new Chapter();
        List<Chapter> chapters = new ArrayList<Chapter>();
        chapters.add(chapter);
        manga.setChapters(chapters);
        assertEquals(manga.getChapters(), chapters);
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
