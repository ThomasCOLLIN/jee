/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtiservices;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author REMI
 */
@XmlRootElement(name = "chapter")
public class Chapter {
	long id;
	int number;

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
	public long getNumber()
	{
		return this.number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}
}

