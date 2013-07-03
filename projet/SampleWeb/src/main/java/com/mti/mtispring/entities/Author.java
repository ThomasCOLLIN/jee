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
 *
 * @author REMI
 */
@Entity
@Table(name="author")
@XmlRootElement(name = "author")
public class Author implements Serializable {
        
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	long id;
        @Column(name="firstname")
	String firstname;
        @Column(name="lastname")
	String lastname;
        @Column(name="type")
	String type;

	@XmlAttribute
	public long getId()
	{
		return this.id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	@XmlAttribute
	public String getFirstname()
	{
		return this.firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	@XmlAttribute
	public String getLastname()
	{
		return this.lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	@XmlAttribute
	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
}

