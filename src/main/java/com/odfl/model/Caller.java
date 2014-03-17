/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.odfl.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "CALLER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caller.findAll", query = "SELECT c FROM Caller c"),
    @NamedQuery(name = "Caller.findByCallerid", query = "SELECT c FROM Caller c WHERE c.callerid = :callerid"),
    @NamedQuery(name = "Caller.findByFirstname", query = "SELECT c FROM Caller c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Caller.findByLastname", query = "SELECT c FROM Caller c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Caller.findByPhonenum", query = "SELECT c FROM Caller c WHERE c.phonenum = :phonenum"),
    @NamedQuery(name = "Caller.findByShipperid", query = "SELECT c FROM Caller c WHERE c.shipperid = :shipperid")})
public class Caller implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALLERID")
    private Integer callerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "PHONENUM")
    private String phonenum;
    @Column(name = "SHIPPERID")
    private Integer shipperid;

    public Caller() {
    }

    public Caller(Integer callerid) {
        this.callerid = callerid;
    }

    public Caller(Integer callerid, String firstname, String lastname, String phonenum) {
        this.callerid = callerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenum = phonenum;
    }

    public Integer getCallerid() {
        return callerid;
    }

    public void setCallerid(Integer callerid) {
        this.callerid = callerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Integer getShipperid() {
        return shipperid;
    }

    public void setShipperid(Integer shipperid) {
        this.shipperid = shipperid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (callerid != null ? callerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caller)) {
            return false;
        }
        Caller other = (Caller) object;
        if ((this.callerid == null && other.callerid != null) || (this.callerid != null && !this.callerid.equals(other.callerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.odfl.model.Caller[ callerid=" + callerid + " ]";
    }
    
}
