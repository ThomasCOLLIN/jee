/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtiservices;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author REMI
 */
@XmlRootElement(name = "manga")
public class Manga {

    long id;
    String name;
    String description;
    List<Chapter> chapters;
    List<Author> authors;
    List<Genre> genres;

    @XmlAttribute
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlAttribute
    public String getName() {
        return this.name;
    }

    public void getName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public List<Chapter> getChapters() {
        return this.chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }

    @XmlElement
    public List<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    @XmlElement
    public List<Genre> getGenres() {
        return this.genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }
}
