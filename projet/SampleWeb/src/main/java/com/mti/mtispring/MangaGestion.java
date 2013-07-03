/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import com.mti.mtispring.businessManagament.MangaList;
import com.mti.mtispring.businessManagament.Zip;
//import com.mti.mtispring.dataAccess.AuthorDAO;
//import com.mti.mtispring.dataAccess.ChapterDAO;
//import com.mti.mtispring.dataAccess.GenreDAO;
//import com.mti.mtispring.dataAccess.MangaDAO;
//import com.mti.mtispring.entities.Genre;
//import com.mti.mtispring.entities.Manga;
import java.io.Console;
import java.io.File;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import javax.ws.rs.core.MediaType;
import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author REMI
 */
@WebService(endpointInterface = "com.mti.mtispring.MangaService")
public class MangaGestion implements MangaService {

//    @Autowired
//    MangaDAO mangaDAO;
//    @Autowired
//    ChapterDAO chapterDAO;
//    @Autowired
//    AuthorDAO authorDAO;
//    @Autowired
//    GenreDAO genreDAO;
    
    
    @Override
//    @Transactional
    public Response getDownload() {
//        StringBuilder res = new StringBuilder();
//        boolean containsTest = false;
//        for (Genre g :genreDAO.getAll()) {
//            if (g.getName().equals("AAAA")) {
//                genreDAO.remove(g);
//                containsTest = true;
//            } else { 
//                if (g.getName().equals("GGDG")) {
//                g.setName("AAAA");
//                genreDAO.merge(g);
//                containsTest = true;
//                }
//                res = res.append(g.getName()).append(" <br> ");
//            }
//        }
//        if (!containsTest) {
//            Genre g = new Genre();
//            g.setName("GGDG");
//            genreDAO.persist(g);
//            res = res.append(g.getName()).append(" <br> ");
//        }
//        return res.toString();

        String path = new File("").getAbsolutePath()+ File.separator + "test" + File.separator + "test_archive.zip";
        Log.debug(path);
        File file = new File(path);
        System.out.println("Path: " + path);
        Response.ResponseBuilder response = Response.ok(file, MediaType.APPLICATION_OCTET_STREAM);
        response.header("Content-Disposition",
                "attachment; filename=\"toto.zip\"");
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
