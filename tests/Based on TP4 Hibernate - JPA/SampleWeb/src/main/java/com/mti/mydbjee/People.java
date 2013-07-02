/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mti.mydbjee;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author REMI
 */
@Entity
@Table(name = "people")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p"),
    @NamedQuery(name = "People.findById", query = "SELECT p FROM People p WHERE p.id = :id"),
    @NamedQuery(name = "People.findByName", query = "SELECT p FROM People p WHERE p.name = :name"),
    @NamedQuery(name = "People.findByFirstname", query = "SELECT p FROM People p WHERE p.firstname = :firstname")})
public class People implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "firstname")
    private String firstname;

    public People() {
    }

    public People(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mti.mydbjee.People[ id=" + id + " ]";
    }
    
}
