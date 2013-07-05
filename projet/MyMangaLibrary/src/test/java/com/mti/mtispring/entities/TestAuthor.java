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
public class TestAuthor extends TestCase {

    public TestAuthor(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(TestAuthor.class);
    }

    public void testNull() {
        Author author = new Author();
        assertNotNull(author);
    }

    public void testFirstname() {
        Author author = new Author();
        author.setFirstname("firstname");
        assertEquals(author.getFirstname(), "firstname");
    }

    public void testLastname() {
        Author author = new Author();
        author.setLastname("lastname");
        assertEquals(author.getLastname(), "lastname");
    }

    public void testId() {
        Author author = new Author();
        author.setId(3);
        assertEquals(author.getId(), 3);
    }

    public void testType() {
        Author author = new Author();
        author.setType("type");
        assertEquals(author.getType(), "type");
    }

    public void testFullAuthor() {
        Author author = new Author();
        author.setFirstname("firstname");
        author.setLastname("lastname");
        author.setId(3);
        author.setType("type");

        assertEquals(author.getFirstname(), "firstname");
        assertEquals(author.getLastname(), "lastname");
        assertEquals(author.getId(), 3);
        assertEquals(author.getType(), "type");
    }
}
