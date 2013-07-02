/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mtispring.db.entities;

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
 * @author goldsz_c
 */
@Entity
@Table(name="Chapter")
@XmlRootElement(name = "chapter")
public class Chapter implements Serializable {
        
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	long id;
        @Column(name="number")
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

