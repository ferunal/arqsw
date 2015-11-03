/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unniminuto.lchacon.estampateem.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author fercris
 */
@Entity
@Table(name = "prd_temaest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrdTemaest.findAll", query = "SELECT p FROM PrdTemaest p"),
    @NamedQuery(name = "PrdTemaest.findByTmeId", query = "SELECT p FROM PrdTemaest p WHERE p.tmeId = :tmeId"),
    @NamedQuery(name = "PrdTemaest.findByTmeNombre", query = "SELECT p FROM PrdTemaest p WHERE p.tmeNombre = :tmeNombre"),
    @NamedQuery(name = "PrdTemaest.findByTmeDesc", query = "SELECT p FROM PrdTemaest p WHERE p.tmeDesc = :tmeDesc"),
    @NamedQuery(name = "PrdTemaest.findByTmeEst", query = "SELECT p FROM PrdTemaest p WHERE p.tmeEst = :tmeEst"),
    @NamedQuery(name = "PrdTemaest.findByIndversion", query = "SELECT p FROM PrdTemaest p WHERE p.indversion = :indversion")})
public class PrdTemaest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tme_id")
    private Integer tmeId;
    @Size(max = 200)
    @Column(name = "tme_nombre")
    private String tmeNombre;
    @Size(max = 2147483647)
    @Column(name = "tme_desc")
    private String tmeDesc;
    @Column(name = "tme_est")
    private Boolean tmeEst;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "tmeId")
    private List<PrdEstampa> prdEstampaList;

    public PrdTemaest() {
    }

    public PrdTemaest(Integer tmeId) {
        this.tmeId = tmeId;
    }

    public Integer getTmeId() {
        return tmeId;
    }

    public void setTmeId(Integer tmeId) {
        this.tmeId = tmeId;
    }

    public String getTmeNombre() {
        return tmeNombre;
    }

    public void setTmeNombre(String tmeNombre) {
        this.tmeNombre = tmeNombre;
    }

    public String getTmeDesc() {
        return tmeDesc;
    }

    public void setTmeDesc(String tmeDesc) {
        this.tmeDesc = tmeDesc;
    }

    public Boolean getTmeEst() {
        return tmeEst;
    }

    public void setTmeEst(Boolean tmeEst) {
        this.tmeEst = tmeEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<PrdEstampa> getPrdEstampaList() {
        return prdEstampaList;
    }

    public void setPrdEstampaList(List<PrdEstampa> prdEstampaList) {
        this.prdEstampaList = prdEstampaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmeId != null ? tmeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdTemaest)) {
            return false;
        }
        PrdTemaest other = (PrdTemaest) object;
        if ((this.tmeId == null && other.tmeId != null) || (this.tmeId != null && !this.tmeId.equals(other.tmeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.PrdTemaest[ tmeId=" + tmeId + " ]";
    }
    
}
