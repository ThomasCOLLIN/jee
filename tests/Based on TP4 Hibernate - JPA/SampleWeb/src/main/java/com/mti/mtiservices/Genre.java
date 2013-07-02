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
@XmlRootElement(name = "genre")
public class Genre {
	long id;
	String name;

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
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
