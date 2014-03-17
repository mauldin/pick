/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.odfl.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "SHIPPICKUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shippickup.findAll", query = "SELECT s FROM Shippickup s"),
    @NamedQuery(name = "Shippickup.findBySpid", query = "SELECT s FROM Shippickup s WHERE s.spid = :spid"),
    @NamedQuery(name = "Shippickup.findByRequesteddt", query = "SELECT s FROM Shippickup s WHERE s.requesteddt = :requesteddt"),
    @NamedQuery(name = "Shippickup.findByStartshiptime", query = "SELECT s FROM Shippickup s WHERE s.startshiptime = :startshiptime"),
    @NamedQuery(name = "Shippickup.findByEndshiptime", query = "SELECT s FROM Shippickup s WHERE s.endshiptime = :endshiptime"),
    @NamedQuery(name = "Shippickup.findBySecondarynum", query = "SELECT s FROM Shippickup s WHERE s.secondarynum = :secondarynum"),
    @NamedQuery(name = "Shippickup.findBySpotpick", query = "SELECT s FROM Shippickup s WHERE s.spotpick = :spotpick"),
    @NamedQuery(name = "Shippickup.findByAppointmentreq", query = "SELECT s FROM Shippickup s WHERE s.appointmentreq = :appointmentreq")})
public class Shippickup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPID")
    private Integer spid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUESTEDDT")
    @Temporal(TemporalType.DATE)
    private Date requesteddt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTSHIPTIME")
    @Temporal(TemporalType.TIME)
    private Date startshiptime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENDSHIPTIME")
    @Temporal(TemporalType.TIME)
    private Date endshiptime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "SECONDARYNUM")
    private String secondarynum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "SPOTPICK")
    private String spotpick;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "APPOINTMENTREQ")
    private String appointmentreq;
    @JoinColumn(name = "SHIPPERID", referencedColumnName = "SHIPPERID")
    @ManyToOne(optional = false)
    private Shipper shipperid;

    public Shippickup() {
    }

    public Shippickup(Integer spid) {
        this.spid = spid;
    }

    public Shippickup(Integer spid, Date requesteddt, Date startshiptime, Date endshiptime, String secondarynum, String spotpick, String appointmentreq) {
        this.spid = spid;
        this.requesteddt = requesteddt;
        this.startshiptime = startshiptime;
        this.endshiptime = endshiptime;
        this.secondarynum = secondarynum;
        this.spotpick = spotpick;
        this.appointmentreq = appointmentreq;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public Date getRequesteddt() {
        return requesteddt;
    }

    public void setRequesteddt(Date requesteddt) {
        this.requesteddt = requesteddt;
    }

    public Date getStartshiptime() {
        return startshiptime;
    }

    public void setStartshiptime(Date startshiptime) {
        this.startshiptime = startshiptime;
    }

    public Date getEndshiptime() {
        return endshiptime;
    }

    public void setEndshiptime(Date endshiptime) {
        this.endshiptime = endshiptime;
    }

    public String getSecondarynum() {
        return secondarynum;
    }

    public void setSecondarynum(String secondarynum) {
        this.secondarynum = secondarynum;
    }

    public String getSpotpick() {
        return spotpick;
    }

    public void setSpotpick(String spotpick) {
        this.spotpick = spotpick;
    }

    public String getAppointmentreq() {
        return appointmentreq;
    }

    public void setAppointmentreq(String appointmentreq) {
        this.appointmentreq = appointmentreq;
    }

    public Shipper getShipperid() {
        return shipperid;
    }

    public void setShipperid(Shipper shipperid) {
        this.shipperid = shipperid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spid != null ? spid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shippickup)) {
            return false;
        }
        Shippickup other = (Shippickup) object;
        if ((this.spid == null && other.spid != null) || (this.spid != null && !this.spid.equals(other.spid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.odfl.model.Shippickup[ spid=" + spid + " ]";
    }
    
}
