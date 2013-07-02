package com.mti.mtiservices;

//import Model.*;
import java.util.List;

public class MangaManager {

//    private DAO dbo = new DAO();

    public List<Manga> getAllManga() {
        // appel a la dao 
		/* SELECT
         Manga.id,
         Manga.name,
         Manga.description,
         Chapter.id,
         Chapter.number,
         Author.id,
         Author.firstname,
         Author.lastname,
         Author.type,
         Genre.id,
         Genre.name
         FROM
         Manga
         JOIN
         Chapter
         ON
         Chapter.idManga = Manga.id
         JOIN
         MangaAuthor
         ON
         MangaAuthor.idManga = Manga.id
         JOIN
         Author
         ON
         Author.id = MangaAuthor.idAuthor
         JOIN
         MangaGenre
         ON
         MangaGenre.idManga = Manga.id
         JOIN
         Genre
         ON
         Genre.id = MangaGenre.idGenre
         ORDER BY
         Manga.id, Chapter.number;
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Manga getManga(long id) {
        /* SAME AS ABOVE + 
         WHERE
         Manga.id = id */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Manga> getMangaByName(String name) {
        /* WHERE
         Manga.name = name*/
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Manga> getMangaByAuthors(List<String> authors) {
        /* WHERE 
         Authors.lastname IN (dump(authors)) */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Manga> getMangaByGenre(List<String> genres) {
        /* WHERE
         Genres.name IN (dump(genres))
         */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Manga> getMangaByBoth(List<String> authors, List<String> genres) {
        /* WHERE
         Genres.name IN (dump(genres))
         AND
         Authors.name IN (dump(authors)) */
        throw new UnsupportedOperationException("Not supported yet.");
    }
}