/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.dataAccess;

import com.mti.mtispring.entities.Chapter;
import com.mti.mtispring.entities.Manga;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author collin_t
 */
public class ChapterDAOTest {
    
    @Autowired
    ChapterDAO chapterDao;
    
    public ChapterDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of persist method, of class ChapterDAO.
     */
    @Test
    public void testPersist() {
        System.out.println("persist");
        Chapter chapter = new Chapter();
        chapter.setFilePath("path");
        chapter.setNumber(143);
        chapter.setMangaId(2);
        chapterDao.persist(chapter);
        assertNotNull(chapterDao.findById(chapter.getId()));
    }

    /**
     * Test of remove method, of class ChapterDAO.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Chapter chapter = null;
        chapterDao.remove(chapter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merge method, of class ChapterDAO.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        Chapter chapter = null;
        chapterDao.merge(chapter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ChapterDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List expResult = null;
        List result = chapterDao.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class ChapterDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        long id = 0L;
        Chapter expResult = null;
        Chapter result = chapterDao.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
