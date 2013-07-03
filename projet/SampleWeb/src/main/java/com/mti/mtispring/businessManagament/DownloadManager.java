package com.mti.mtispring.businessManagament;

import java.io.File;
import java.util.ArrayList;
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
        // TODO: Implement the method
        //throw new UnsupportedOperationException("Not supported yet.");
        return "This is Sparta";
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
    
    public List<String> getChaptersPathByManga(long mangaId, List<Long> chaptersId)
    {
        return getChaptersPathByManga(mangaId);
        // TODO: Implement the method
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * @param id : Identifier of a manga into the database.
     * @return The path of each chapter of the manga.
     */
    public List<String> getChaptersPathByManga(long id){
        ArrayList<String> paths = new ArrayList<String>(); 
        
        paths.add(new File("").getAbsolutePath()+ File.separator + "test" + File.separator + "test_archive.zip");
        paths.add(new File("").getAbsolutePath()+ File.separator + "test" + File.separator + "test_archive2.zip");
        paths.add("http://dl.crazytje.be/dl.php?id=70qbh1783uh33ibaip4j7dj8d7&file=51d40c66-1ab4-4b9b-9dc9-7fa4d0359e0c&lid=51d40c66-54dc-4448-b35c-7fa4d0359e0c");
        return paths;
        // TODO: Implement the method
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}