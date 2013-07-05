/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * A chapter of a manga. Chapters can be downloaded by a webservice. It can be
 * translated as a XML
 *
 * @author goldsz_c
 */
@Entity
@Table(name = "chapter")
@XmlType(name = "chapter")
public class Chapter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(name = "number")
    float number;
    @Column(name = "idManga")
    long mangaId;
    @Column(name = "file_path")
    String filePath;

    /**
     * @return the chapter id
     */
    @XmlAttribute
    public long getId() {
        return this.id;
    }

    /**
     * set the chapter id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the number of the chapter. Unique for a manga
     */
    @XmlAttribute
    public float getNumber() {
        return this.number;
    }

    /**
     * set the number of a chapter
     */
    public void setNumber(float number) {
        this.number = number;
    }

    /**
     * @return the id of the manga the chapter belongs to
     */
    public long getMangaId() {
        return mangaId;
    }

    /**
     * set the id of the manga the chapter belongs to
     */
    public void setMangaId(long mangaId) {
        this.mangaId = mangaId;
    }

    /**
     * @return the path of the file containing the chapter on the server
     */
    @XmlAttribute
    public String getFilePath() {
        return filePath;
    }

    /**
     * set the path of the file containing the chapter on the server
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
