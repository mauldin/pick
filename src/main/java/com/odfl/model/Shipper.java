/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.odfl.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "SHIPPER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shipper.findAll", query = "SELECT s FROM Shipper s"),
    @NamedQuery(name = "Shipper.findByShipperid", query = "SELECT s FROM Shipper s WHERE s.shipperid = :shipperid"),
    @NamedQuery(name = "Shipper.findByShippername", query = "SELECT s FROM Shipper s WHERE s.shippername = :shippername"),
    @NamedQuery(name = "Shipper.findByPhone", query = "SELECT s FROM Shipper s WHERE s.phone = :phone"),
    @NamedQuery(name = "Shipper.findByRoute", query = "SELECT s FROM Shipper s WHERE s.route = :route"),
    @NamedQuery(name = "Shipper.findByCredit", query = "SELECT s FROM Shipper s WHERE s.credit = :credit"),
    @NamedQuery(name = "Shipper.findByComments", query = "SELECT s FROM Shipper s WHERE s.comments = :comments")})
public class Shipper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SHIPPERID")
    private Integer shipperid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SHIPPERNAME")
    private String shippername;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROUTE")
    private String route;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CREDIT")
    private String credit;
    @Size(max = 200)
    @Column(name = "COMMENTS")
    private String comments;
    @JoinColumn(name = "CONTACTID", referencedColumnName = "CONTACTID")
    @ManyToOne(optional = false)
    private Contact contactid;
    @JoinColumn(name = "ADDRESSID", referencedColumnName = "ADDRESSID")
    @ManyToOne
    private Address addressid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipperid")
    private Collection<Shippickup> shippickupCollection;

    public Shipper() {
    }

    public Shipper(Integer shipperid) {
        this.shipperid = shipperid;
    }

    public Shipper(Integer shipperid, String shippername, String phone, String route, String credit) {
        this.shipperid = shipperid;
        this.shippername = shippername;
        this.phone = phone;
        this.route = route;
        this.credit = credit;
    }

    public Integer getShipperid() {
        return shipperid;
    }

    public void setShipperid(Integer shipperid) {
        this.shipperid = shipperid;
    }

    public String getShippername() {
        return shippername;
    }

    public void setShippername(String shippername) {
        this.shippername = shippername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Contact getContactid() {
        return contactid;
    }

    public void setContactid(Contact contactid) {
        this.contactid = contactid;
    }

    public Address getAddressid() {
        return addressid;
    }

    public void setAddressid(Address addressid) {
        this.addressid = addressid;
    }

    @XmlTransient
    public Collection<Shippickup> getShippickupCollection() {
        return shippickupCollection;
    }

    public void setShippickupCollection(Collection<Shippickup> shippickupCollection) {
        this.shippickupCollection = shippickupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipperid != null ? shipperid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shipper)) {
            return false;
        }
        Shipper other = (Shipper) object;
        if ((this.shipperid == null && other.shipperid != null) || (this.shipperid != null && !this.shipperid.equals(other.shipperid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.odfl.model.Shipper[ shipperid=" + shipperid + " ]";
    }
    
}
