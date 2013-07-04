/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring;

import com.mti.mtispring.businessManagament.*;
import com.mti.mtispring.dataAccess.ChapterDAO;
import com.mti.mtispring.dataAccess.MangaDAO;
import com.mti.mtispring.entities.Chapter;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
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

    @Override
    public Response getDownload(HttpServletRequest request) throws Exception {
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
            chapterMap.put(mangaName + "-" + ((Long) chapter.getNumber()).toString(), chapter.getFilePath());
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
