package com.mti.mtispring.businessManagament;

import com.mti.mtispring.dataAccess.ChapterDAO;
import com.mti.mtispring.dataAccess.MangaDAO;
import com.mti.mtispring.entities.Chapter;
import com.mti.mtispring.entities.Manga;
import java.util.List;

public class DownloadManager {

    public List<String> getManga(long id) {
        /* SELECT
         Chapter.file_path
         FROM
         Chapter
         WHERE
         Chapter.idManga = id */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getMangaName(long mangaId){
        MangaDAO mangaDAO =  new MangaDAO();
        Manga manga = mangaDAO.findById(mangaId);
        
        return manga != null ? manga.getName() : null;
    }
    
    public String getChapter(long id) {
        /* SELECT
         Chapter.file_path
         FROM
         Chapter
         WHERE
         Chapter.id = id; */
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<Chapter> getChaptersByManga(long mangaId, List<Long> chaptersId)
    {
        ChapterDAO chapterDAO =  new ChapterDAO();
        
        return chapterDAO.findByMangaId(mangaId, chaptersId);
    }
    
    public List<Chapter> getChaptersByManga(long mangaId){
        
        ChapterDAO chapterDAO =  new ChapterDAO();
        
        return chapterDAO.findByMangaId(mangaId);
    }
}