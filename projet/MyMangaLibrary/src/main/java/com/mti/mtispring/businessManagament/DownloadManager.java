package com.mti.mtispring.businessManagament;

import com.mti.mtispring.dataAccess.ChapterDAO;
import com.mti.mtispring.dataAccess.MangaDAO;
import com.mti.mtispring.entities.Chapter;
import com.mti.mtispring.entities.Manga;
import java.util.List;
import javax.persistence.NoResultException;

/**
 * class managing download services
 * @author collin_t
 */
public class DownloadManager {

    private MangaDAO mangaDAO;
    private ChapterDAO chapterDAO;

    public DownloadManager(MangaDAO mangaDAO, ChapterDAO chapterDAO) {
        this.mangaDAO = mangaDAO;
        this.chapterDAO = chapterDAO;
    }

    /**
     * get the name of a manga
     * @param mangaId id of the manga
     * @return the name of the manga or null if it doesn't exist
     */
    public String getMangaName(long mangaId) {
        try {
            Manga manga = mangaDAO.findById(mangaId);
            return manga.getName();

        } catch (NoResultException e) {
            return null;
        }
    }
    
    /**
     * return a list of chapter from one manga
     * @param mangaId the id of the manga
     * @param chaptersId the ids of chapters
     * @return the list of chapter
     */
    public List<Chapter> getChaptersByManga(long mangaId, List<Long> chaptersId) {
        return chapterDAO.findByMangaId(mangaId, chaptersId);
    }

    /**
     * return all the chapters of a manga
     * @param mangaId the id of the manga
     * @return all the corresponding chapters
     */ 
    public List<Chapter> getChaptersByManga(long mangaId) {
        return chapterDAO.findByMangaId(mangaId);
    }
}