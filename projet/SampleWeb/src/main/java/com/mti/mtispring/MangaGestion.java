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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
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

    /**
     * Webservice allowing to download a manga
     * syntax : {url}/rest/download/?id={mangaid}[&chapterId={chapterid}]+
     */
    @Override
    public Response getDownload(HttpServletRequest request) {
        DownloadManager downloadManager = new DownloadManager(mangaDAO, chapterDAO);
        Enumeration<String> parameters = request.getParameterNames();
        int parameterNumber;
        
        if (!parameters.hasMoreElements() || ((parameterNumber = request.getParameterMap().size()) > 2)) {
            return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                    .entity("Request must be: /download?id={mangaid}[&chapterId={chapterid}...]").build();
        }
        
        String[] ids = request.getParameterValues("id");
        
        if (ids == null) {
            return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                    .entity("Request must be: /download?id={mangaid}[&chapterId={chapterid}...]").build();
        }
        if (ids.length > 1) {
            return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                    .entity("The parameter 'id' must be unique.").build();
        }
        
        long mangaId = 0;
        try {
            mangaId = Long.parseLong(ids[0]);
        } catch (NumberFormatException e) {
            return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                    .entity("The parameter 'id' must be an integer.").build();
        }
        String mangaName = downloadManager.getMangaName(mangaId);
        
        if (mangaName == null) {
            return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                    .entity("Invalid request: The manga doesn't exist.").build();
        }
        
        ByteArrayOutputStream zipFile;
        List<Chapter> chapters;
        String[] chaptersId = request.getParameterValues("chapterId");
        /* If all the chapters are requested. */
        if (chaptersId == null) {
            if (parameterNumber >= 2) {
                return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                        .entity("Request must be: /download?id={mangaid}[&chapterId={chapterid}...]").build();
            }
            chapters = downloadManager.getChaptersByManga(mangaId);
        } else {
            ArrayList<Long> chaptersIdLong = new ArrayList<Long>();
            try {
                for (String string : chaptersId) {
                    chaptersIdLong.add(Long.parseLong(string));
                }
            } catch (Exception e) {
                return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                        .entity("The parameter 'chapterId' must be an integer.").build();
            }
            
            chapters = downloadManager.getChaptersByManga(mangaId, chaptersIdLong);
        }
        
        if (chapters.isEmpty()) {
            return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                    .entity("Invalid request: No chapter found.").build();
        }
        
        Map<String, String> chapterMap = new HashMap<String, String>();
        
        for (Chapter chapter : chapters) {
            chapterMap.put(mangaName + "-" + ((Float) chapter.getNumber()).toString(), chapter.getFilePath());
        }
        
        zipFile = Zip.getZip(chapterMap);
        
        byte[] bytearray;
        if (zipFile != null) {
            bytearray = zipFile.toByteArray();
            return Response.ok(bytearray, MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + mangaName + ".zip\"").build();
        } else {
            return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.TEXT_HTML_TYPE)
                    .entity("Impossible to generate the file.").build();
        }
    }


    /**
    * Webservice allowing to search for one or more mangas in the database
    * syntax : {url} + 
    *       /manga?id={id} -> get manga by its Id
    *       /manga?name={name} - get a manga by its name
    *       /manga?author={author}[&author={author}]* get mangas created by at least one of the authors
    *       /manga?genre={genre}[&genre={genre}]* get mangas having at least one genre in the list
    */
    @Override
    public Response getManga(HttpServletRequest request) throws Exception {
        MangaManager mangaManager = new MangaManager(mangaDAO);
        Enumeration<String> parameters = request.getParameterNames();
        MangaList mangas;
        
        if (!parameters.hasMoreElements()) {
            return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                    .entity("Parameters are missing.").build();
        }
        if (request.getParameterMap().size() > 1) {
            return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                    .entity("Too many parameters.").build();
        }
        
        String[] ids = request.getParameterValues("id");
        String[] names = request.getParameterValues("name");
        String[] authors = request.getParameterValues("author");
        String[] genres = request.getParameterValues("genre");
        
        if (ids != null) {
            if (ids.length > 1) {
                return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                        .entity("The parameter 'id' must be unique.").build();
            }
            try {
                long id;
                id = Long.parseLong(ids[0]);
                Manga manga = mangaManager.getManga(id);
                if (manga == null) {
                    return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                            .entity("Manga not found.").build();
                }
                List<Manga> mangaArray = new ArrayList<Manga>();
                mangaArray.add(manga);
                mangas = new MangaList(mangaArray);
                
            } catch (NumberFormatException e) {
                return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                        .entity("The parameter 'id' must be an integer.").build();
            }
        } else if (names != null) {
            if (names.length > 1) {
                return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                        .entity("The parameter 'name' must be unique.").build();
            }
            mangas = mangaManager.getMangaByName(names[0]);
            
        } else if (authors != null) {
            List<String> authorsList = new ArrayList<String>();
            authorsList.addAll(Arrays.asList(authors));
            
            mangas = mangaManager.getMangaByAuthors(authorsList);
            
        } else if (genres != null) {
            List<String> genresList = new ArrayList<String>();
            genresList.addAll(Arrays.asList(genres));
            
            mangas = mangaManager.getMangaByGenre(genresList);
            
        } else {
            return Response.status(Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE)
                    .entity("Invalid parameter(s).").build();
        }
        
        if (mangas.getMangas().isEmpty()) {
            return Response.status(Status.OK).type(MediaType.TEXT_HTML_TYPE)
                    .entity("No manga found.").build();
        }
        
        return Response.ok(mangas, MediaType.APPLICATION_XML).build();        
    }
}
