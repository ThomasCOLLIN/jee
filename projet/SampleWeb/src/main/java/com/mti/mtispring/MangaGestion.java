/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import com.mti.mtispring.businessManagament.*;
import com.mti.mtispring.dataAccess.MangaDAO;
import java.io.File;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.ws.rs.core.MediaType;
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
    
    @Override
    public Response getDownload() {
        String path = new File("").getAbsolutePath()+ File.separator + "test" + File.separator + "test_archive.zip";
        Log.debug(path);
        File file = new File(path);
        System.out.println("Path: " + path);

        Response.ResponseBuilder response = Response.ok(file, MediaType.APPLICATION_OCTET_STREAM);
		response.header("Content-Disposition",
			"attachment; filename=\"toto.zip\"");
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
//    public Response getDownload(@Context UriInfo info) {
//        BusinessManagement.DownloadManager downloadManager = new BusinessManagement.DownloadManager();
//        MultivaluedMap<String, String> queryParams = info.getQueryParameters();
//        Long mangaId = null;
//        if (queryParams.isEmpty()) {
//            throw new Exception("Invalid request : cannot download with no argument");
//        }
//
//        if (!queryParams.get("id").isEmpty()) {
//            if (queryParams.get("id").size() > 1) {
//                throw new Exception("Invalid request : id param must be unique");
//            }
//            mangaId = Long.parseLong(queryParams.get("id"));
//        }
//
//        if (queryParams.get("chapter").isEmpty() && queryParams.get("chapterId").isEmpty()) {
//            File zip = ZipIt.zipeFiles(downloadManager.getChaptersPath(mangaId));
//            return zip;
//        }
//
//        if (!queryParams.get("chapter").isEmpty()) {
//            if (mangaId == null) {
//                throw new Exception("Invalid request : chapter not a valid argument without a manga id");
//            }
//            List<String> chapters = queryParams.get("chapter");
//
//            List<String> chaptersPath = downloadManager.getChaptersPath(mangaId, chapters);
//            File zip = Zip.zipFiles(chaptersPath);
//            return zip;
//        }
//        if (queryParams.get("chapterId").isEmpty() || queryParams.get("chapterId").size() > 1) {
//            throw new Exception("Invalid resquest : chapterId param must be unique");
//        }
//        String chapterId = Long.parseLong(queryParams.getFirst("chapterId"));
//        File zip = downloadManager.getChapterFile(chapterId);
//        return zip;
//    }

}
