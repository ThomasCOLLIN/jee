/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A manga. this class is used to stock mangas in database. It can also convert a manga in XML
 * @author goldsz_c
 */
@Entity
@Table(name="manga")
@XmlType(name = "manga")
public class Manga implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="chapter",
            joinColumns = { @JoinColumn(name="idManga")},
            inverseJoinColumns = {@JoinColumn(name="id")})// pas sur qu'on ait besoin de inverseJoin column...
    private List<Chapter> chapters;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="mangaauthor",
            joinColumns = { @JoinColumn(name="idManga")},
            inverseJoinColumns = {@JoinColumn(name="idAuthor")})
    private List<Author> authors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="mangagenre",
            joinColumns = {@JoinColumn(name="idManga")},
            inverseJoinColumns = {@JoinColumn(name="idGenre")})
    private List<Genre> genres;

    /**
    * @return the id of the manga.
    */
    @XmlAttribute
    public long getId() {
        return this.id;
    }

    /**
    * set the id of the manga
    */
    public void setId(long id) {
        this.id = id;
    }

    /**
    * @return the name of the manga
    */
    @XmlAttribute
    public String getName() {
        return this.name;
    }

    /**
    * set the name of the manga
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * @return a description of the manga
    */
    @XmlElement(name ="description")
    public String getDescription() {
        return this.description;
    }

    /**
    * set the description of the manga
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
    * @return all the available chapters for this manga
    */
    @XmlElement(name = "chapter")
    public List<Chapter> getChapters() {
        return this.chapters;
    }

    /**
    * set the chapter list
    */
    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    /**
    * add a chapter
    */
    public void addChapter(Chapter chapter) {
        if (this.chapters == null) {
            this.chapters = new ArrayList<Chapter>();
        }
        this.chapters.add(chapter);
    }

    /**
    * @return the author(s) of the manga.
    */
    @XmlElement(name = "author")
    public List<Author> getAuthors() {
        return this.authors;
    }

    /**
    * set the author(s) of the manga
    */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    /**
    * add an author to the manga
    */
    public void addAuthor(Author author) {
        if (this.authors == null) {
            this.authors = new ArrayList<Author>();
        }
        this.authors.add(author);
    }

    /**
    * @return the genres
    */
    @XmlElement(name = "genre")
    public List<Genre> getGenres() {
        return this.genres;
    }

    /**
    * set the genres
    */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
    * add a genre
    */
    public void addGenre(Genre genre) {
        if (this.authors == null) {
            this.authors = new ArrayList<Author>();
        }
        this.genres.add(genre);
    }
}
