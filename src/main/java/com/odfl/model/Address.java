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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "ADDRESS", schema = "SAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressid", query = "SELECT a FROM Address a WHERE a.addressid = :addressid"),
    @NamedQuery(name = "Address.findByAddressone", query = "SELECT a FROM Address a WHERE a.addressone = :addressone"),
    @NamedQuery(name = "Address.findByAddresstwo", query = "SELECT a FROM Address a WHERE a.addresstwo = :addresstwo"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByZip", query = "SELECT a FROM Address a WHERE a.zip = :zip")})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDRESSID")
    private Integer addressid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "ADDRESSONE")
    private String addressone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "ADDRESSTWO")
    private String addresstwo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ZIP")
    private String zip;
    @OneToOne(mappedBy = "addressid")
    private Shipper shipper;
    @JoinColumn(name = "STATEID", referencedColumnName = "STATEID")
    @ManyToOne(optional = false)
    private Statetb stateid;

    public Address() {
        stateid = new Statetb();
    }

    public Address(Integer addressid) {
        this.addressid = addressid;
    }

    public Address(Integer addressid, String addressone, String addresstwo, String city, String zip) {
        this.addressid = addressid;
        this.addressone = addressone;
        this.addresstwo = addresstwo;
        this.city = city;
        this.zip = zip;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getAddressone() {
        return addressone;
    }

    public void setAddressone(String addressone) {
        this.addressone = addressone;
    }

    public String getAddresstwo() {
        return addresstwo;
    }

    public void setAddresstwo(String addresstwo) {
        this.addresstwo = addresstwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @XmlTransient
    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Statetb getStateid() {
        return stateid;
    }

    public void setStateid(Statetb stateid) {
        this.stateid = stateid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.odfl.model.Address[ addressid=" + addressid + " ]";
    }
    
}
