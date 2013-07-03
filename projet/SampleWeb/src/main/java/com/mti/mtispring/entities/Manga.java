/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author goldsz_c
 */
@Entity
@Table(name="manga")
@XmlRootElement(name = "manga")
public class Manga implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    
    @Column(name="name")
    String name;
    
    @Column(name="description")
    String description;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="chapter",
            joinColumns = { @JoinColumn(name="idManga")},
            inverseJoinColumns = {@JoinColumn(name="id")})// pas sur qu'on ait besoin de inverseJoin column...
    List<Chapter> chapters;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="mangaauthor",
            joinColumns = { @JoinColumn(name="idManga")},
            inverseJoinColumns = {@JoinColumn(name="idAuthor")})
    List<Author> authors;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="mangagenre",
            joinColumns = {@JoinColumn(name="idManga")},
            inverseJoinColumns = {@JoinColumn(name="idGenre")})
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

    public void setName(String name) {
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
