package com.mti.mtispring.businessManagament;

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

    public String getChapter(long id) {
        /* SELECT
         Chapter.file_path
         FROM
         Chapter
         WHERE
         Chapter.id = id; */
        throw new UnsupportedOperationException("Not supported yet.");
    }
}