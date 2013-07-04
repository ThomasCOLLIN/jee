/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import com.mti.mtispring.businessManagament.*;
import com.mti.mtispring.dataAccess.ChapterDAO;
import com.mti.mtispring.dataAccess.MangaDAO;
import com.mti.mtispring.entities.Chapter;
import com.mti.mtispring.entities.Manga;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.core.MediaType;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author REMI
 */
@WebService(endpointInterface = "com.mti.mtispring.MangaService")
public class MangaGestion implements MangaService {

    @Autowired
    MangaDAO mangaDAO;
    @Autowired
    ChapterDAO chapterDAO;
    
    @Override
    public Response getDownload(HttpServletRequest request) throws Exception {
        DownloadManager downloadManager = new DownloadManager(mangaDAO, chapterDAO);
        Enumeration<String> parameters = request.getParameterNames();
        
        if (parameters == null) {
            throw new Exception("Invalid request: cannot download with no argument");
        }

        String[] ids = request.getParameterValues("id");
        
        if (ids == null) {
            throw new Exception("Invalid request: A manga id is required.");
        }
        if (ids.length > 1) {
            throw new Exception("Invalid request: id parameter must be unique");
        }
        
        Long mangaId = Long.parseLong(ids[0]);
        String mangaName = downloadManager.getMangaName(mangaId);
        
        if (mangaName == null) {
            throw new Exception("Invalid request: The manga doesn't exist.");
        }
        
        ByteArrayOutputStream zipFile;
        List<Chapter> chapters;
        String[] chaptersId = request.getParameterValues("chapterId");
        /* If all the chapters are requested. */
        if (chaptersId == null) {
            chapters = downloadManager.getChaptersByManga(mangaId);
        }
        else
        {
            ArrayList<Long> chaptersIdLong = new ArrayList<Long>();
            for (String string : chaptersId) {
                chaptersIdLong.add(Long.parseLong(string));    
            }
            chapters = downloadManager.getChaptersByManga(mangaId, chaptersIdLong);
        }
        
        if (chapters == null) {
            throw new Exception("Invalid request: No chapter found.");
        }
        
        Map<String, String> chapterMap = new HashMap<String, String>();
        
        for (Chapter chapter : chapters) {
            chapterMap.put(mangaName + "-" + ((Long) chapter.getNumber()).toString(), chapter.getFilePath());
        }
        
        zipFile = Zip.getZip(chapterMap);
        
        byte[] bytearray;
        Response.ResponseBuilder response;
        if (zipFile != null) {
            bytearray = zipFile.toByteArray();
            response= Response.ok(bytearray, MediaType.APPLICATION_OCTET_STREAM);
                response.header("Content-Disposition", "attachment; filename=\"" + mangaName + ".zip\"");                
        }
        else
        {
            response = Response.serverError();
        }
        
        return response.build();
        
    }
    @Override
    public MangaList getManga() {
        MangaManager mangaManager = new MangaManager(mangaDAO);
//        MultivaluedMap<String, String> queryParams = info.getQueryParameters();
        //if (queryParams.isEmpty()) {
            // /!\ check not empty /!\
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Action");
        arr.add("Comedy");
        return mangaManager.getMangaByGenre(arr);
        
            //}
    }
//        if (!queryParams.get("id").isEmpty()) {
//            if (queryParams.get("id").size() > 1) {
//                throw new Exception("Invalid request : id param must be unique");
//            }
//            Long id = Long.parseLong(queryParams.getFirst("id"));
//            Manga manga = mangaManager.getManga(id);
//
//            if (queryParams.size() != 1) {
//                throw new Exception("Invalid request : contains unknown parameters");
//            }
//            mangaList.add(manga);
//            return mangaList;
//        }
//        if (!queryParams.get("name").isEmpty()) {
//            if (queryParams.get("name").size() > 1) {
//                throw new Exception("Invalid request : name param must be unique");
//            }
//            String name = queryParams.getFirst("name");
//            List<Manga> mangaList = mangaManager.getMangaByName(name);
//            return mangaList;
//        }
//
//        List<String> genres = queryParams.get("genre");
//        List<String> authors = queryParams.get("author");
//
//        if (genres.isEmpty() && authors.isEmpty()) {
//            throw new Exception("Invalid request : contains unknown parameters");
//        }
//        if (genres.isEmpty()) {
//            return mangaManager.getMangaByAuthors(authors);
//        }
//        if (authors.isEmpty()) {
//            return mangaManager.getMangaByGenres(genres);
//        }
//        return mangaManager.getMangaByBoth(authors, genres);
//    }
//


}
