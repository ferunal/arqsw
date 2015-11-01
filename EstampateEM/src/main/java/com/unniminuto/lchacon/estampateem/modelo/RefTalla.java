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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "ref_talla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefTalla.findAll", query = "SELECT r FROM RefTalla r"),
    @NamedQuery(name = "RefTalla.findByTlaId", query = "SELECT r FROM RefTalla r WHERE r.tlaId = :tlaId"),
    @NamedQuery(name = "RefTalla.findByTlaNombre", query = "SELECT r FROM RefTalla r WHERE r.tlaNombre = :tlaNombre"),
    @NamedQuery(name = "RefTalla.findByTlaDesc", query = "SELECT r FROM RefTalla r WHERE r.tlaDesc = :tlaDesc"),
    @NamedQuery(name = "RefTalla.findByTlaEst", query = "SELECT r FROM RefTalla r WHERE r.tlaEst = :tlaEst"),
    @NamedQuery(name = "RefTalla.findByIndversion", query = "SELECT r FROM RefTalla r WHERE r.indversion = :indversion")})
public class RefTalla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tla_id")
    private Integer tlaId;
    @Column(name = "tla_nombre")
    private String tlaNombre;
    @Column(name = "tla_desc")
    private String tlaDesc;
    @Column(name = "tla_est")
    private Boolean tlaEst;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "tlaId")
    private List<PrdCamiseta> prdCamisetaList;

    public RefTalla() {
    }

    public RefTalla(Integer tlaId) {
        this.tlaId = tlaId;
    }

    public Integer getTlaId() {
        return tlaId;
    }

    public void setTlaId(Integer tlaId) {
        this.tlaId = tlaId;
    }

    public String getTlaNombre() {
        return tlaNombre;
    }

    public void setTlaNombre(String tlaNombre) {
        this.tlaNombre = tlaNombre;
    }

    public String getTlaDesc() {
        return tlaDesc;
    }

    public void setTlaDesc(String tlaDesc) {
        this.tlaDesc = tlaDesc;
    }

    public Boolean getTlaEst() {
        return tlaEst;
    }

    public void setTlaEst(Boolean tlaEst) {
        this.tlaEst = tlaEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<PrdCamiseta> getPrdCamisetaList() {
        return prdCamisetaList;
    }

    public void setPrdCamisetaList(List<PrdCamiseta> prdCamisetaList) {
        this.prdCamisetaList = prdCamisetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tlaId != null ? tlaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefTalla)) {
            return false;
        }
        RefTalla other = (RefTalla) object;
        if ((this.tlaId == null && other.tlaId != null) || (this.tlaId != null && !this.tlaId.equals(other.tlaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.RefTalla[ tlaId=" + tlaId + " ]";
    }
    
}
