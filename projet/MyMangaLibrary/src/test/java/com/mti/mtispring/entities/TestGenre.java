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
public class TestGenre extends TestCase {

    public TestGenre(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(TestGenre.class);
    }

    public void testNull()
    {
        Genre genre = new Genre();
        assertNotNull(genre);
    }
    
    public void testId() {
        Genre genre = new Genre();
        genre.setId(28);
        assertEquals(genre.getId(), 28);
    }

    public void testName() {
        Genre genre = new Genre();
        genre.setName("name");
        assertEquals(genre.getName(), "name");
    }

    public void testFullGenre() {
        Genre genre = new Genre();
        genre.setId(28);
        genre.setName("name");

        assertEquals(genre.getId(), 28);
        assertEquals(genre.getName(), "name");

    }
}
