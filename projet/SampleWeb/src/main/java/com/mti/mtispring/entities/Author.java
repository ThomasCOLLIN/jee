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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * a class representing an author in the database. It can be translated in XML
 * @author REMI
 */
@Entity
@Table(name = "author")
@XmlRootElement(name = "author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(name = "firstname")
    String firstname;
    @Column(name = "lastname")
    String lastname;
    @Column(name = "typeId")
    String type;

    /**
     * @return the id of the author
     */
    @XmlAttribute
    public long getId() {
        return this.id;
    }

    /**
     * set the id of the author
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the firstname of the author
     */
    @XmlAttribute
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * set the firstname of the author
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname of the author
     */
    @XmlAttribute
    public String getLastname() {
        return this.lastname;
    }

    /**
     * set the lastname of the author
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * the type of an authors could be for exemple writter, illustrator, both, etc. 
     * @return the type of the author
     */
    @XmlAttribute
    public String getType() {
        return this.type;
    }

    /**
     * set the type of the author
     */
    public void setType(String type) {
        this.type = type;
    }
}
