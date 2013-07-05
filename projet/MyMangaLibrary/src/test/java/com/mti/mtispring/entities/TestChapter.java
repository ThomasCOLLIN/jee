/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.entities;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author REMI
 */
public class TestChapter extends TestCase {

    public TestChapter(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(TestChapter.class);
    }

    public void testNull()
    {
        Chapter chapter = new Chapter();
        assertNotNull(chapter);
    }
    
    public void testId() {
        Chapter chapter = new Chapter();
        chapter.setId(3);
        assertEquals(chapter.getId(), 3);
    }

    public void testNumber() {
        Chapter chapter = new Chapter();
        chapter.setNumber(42);
        assertEquals(chapter.getNumber(), (float) 42);
    }

    public void testMangaId() {
        Chapter chapter = new Chapter();
        chapter.setMangaId(18);
        assertEquals(chapter.getMangaId(), 18);
    }

    public void testFilePath() {
        Chapter chapter = new Chapter();
        chapter.setFilePath("http://filepath.com");
        assertEquals(chapter.getFilePath(), "http://filepath.com");
    }

    public void testFullChapter() {
        Chapter chapter = new Chapter();
        chapter.setId(3);
        chapter.setNumber(42);
        chapter.setMangaId(18);
        chapter.setFilePath("http://filepath.com");

        assertEquals(chapter.getId(), 3);
        assertEquals(chapter.getNumber(), (float) 42);
        assertEquals(chapter.getMangaId(), 18);
        assertEquals(chapter.getFilePath(), "http://filepath.com");
    }
}
