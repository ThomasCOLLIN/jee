/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import com.mti.mtispring.businessManagament.DownloadManager;
import com.mti.mtispring.businessManagament.MangaList;
import com.mti.mtispring.businessManagament.Zip;
import com.mti.mtispring.entities.Manga;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import javax.ws.rs.core.MediaType;
import org.mortbay.log.Log;

/**
 *
 * @author REMI
 */
@WebService(endpointInterface = "com.mti.mtispring.MangaService")
public class MangaGestion implements MangaService {

    @Override
    public Response getDownload(HttpServletRequest request) throws Exception {
        DownloadManager downloadManager = new DownloadManager();
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
        
        ByteArrayOutputStream zipFile = null;
        List<String> chaptersPath = null;
        String[] chaptersId = request.getParameterValues("chapterId");
        /* If all the chapters are requested. */
        if (chaptersId == null) {
            chaptersPath = downloadManager.getChaptersPathByManga(mangaId);
        }
        else
        {
            ArrayList<Long> chaptersIdLong = new ArrayList<Long>();
            for (String string : chaptersId) {
                chaptersIdLong.add(Long.parseLong(string));    
            }
            chaptersPath = downloadManager.getChaptersPathByManga(mangaId, chaptersIdLong);
        }
        
        if (chaptersPath == null) {
            throw new Exception("Invalid request: No chapter found.");
        }
        
        Hashtable<String, String> chaptersMap = new Hashtable<String, String>();
        Integer count = 0;
        for (String path : chaptersPath) {
            count++;
            chaptersMap.put(mangaName + count.toString(), path);
        }
        
        zipFile = Zip.getZip(chaptersMap);
        
        byte[] bytearray = null;
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
  

//    public MangaList getManga(@Context UriInfo info) {
//        BusinessManagement.MangaManager mangaManager = new BusinessManagement.MangaManager();
//        MultivaluedMap<String, String> queryParams = info.getQueryParameters();
//        if (queryParams.isEmpty()) {
//            List<Manga> mangaList = mangaManager.getAllManga();
//            return mangaList;
//        }
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
