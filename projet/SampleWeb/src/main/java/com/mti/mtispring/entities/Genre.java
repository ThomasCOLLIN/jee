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
 * A genre of manga. It allows to search or order mangas. It can be translate as an XML
 * @author goldsz_c
 */
@Entity
@Table(name="genre")
@XmlRootElement(name = "genre")
public class Genre implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	long id;
        @Column(name="name")
        String name;

    /**
     * get id id of the genre
     */
	@XmlAttribute
	public long getId()
	{
		return this.id;
	}

	/**
	* set the id of the genre
	*/
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	* get the name of the genre
	*/
	@XmlAttribute
	public String getName()
	{
		return this.name;
	}

	/**
	* @deprecated
	* set the name of a genre. genres shouldn't be changed
	*/
	public void setName(String name)
	{
		this.name = name;
	}
}
