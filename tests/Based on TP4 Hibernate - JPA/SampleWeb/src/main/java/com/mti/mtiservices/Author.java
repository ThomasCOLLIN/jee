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
@XmlRootElement(name = "author")
public class Author {
	long id;
	String firstname;
	String lastname;
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

