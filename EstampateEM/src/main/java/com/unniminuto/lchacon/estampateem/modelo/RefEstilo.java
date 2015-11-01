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
@Table(name = "ref_estilo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefEstilo.findAll", query = "SELECT r FROM RefEstilo r"),
    @NamedQuery(name = "RefEstilo.findByEstId", query = "SELECT r FROM RefEstilo r WHERE r.estId = :estId"),
    @NamedQuery(name = "RefEstilo.findByEstNombre", query = "SELECT r FROM RefEstilo r WHERE r.estNombre = :estNombre"),
    @NamedQuery(name = "RefEstilo.findByEstDesc", query = "SELECT r FROM RefEstilo r WHERE r.estDesc = :estDesc"),
    @NamedQuery(name = "RefEstilo.findByEstEst", query = "SELECT r FROM RefEstilo r WHERE r.estEst = :estEst"),
    @NamedQuery(name = "RefEstilo.findByIndversion", query = "SELECT r FROM RefEstilo r WHERE r.indversion = :indversion")})
public class RefEstilo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_id")
    private Integer estId;
    @Size(max = 100)
    @Column(name = "est_nombre")
    private String estNombre;
    @Size(max = 2147483647)
    @Column(name = "est_desc")
    private String estDesc;
    @Column(name = "est_est")
    private Boolean estEst;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "estId")
    private List<PrdCamiseta> prdCamisetaList;

    public RefEstilo() {
    }

    public RefEstilo(Integer estId) {
        this.estId = estId;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstNombre() {
        return estNombre;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    public String getEstDesc() {
        return estDesc;
    }

    public void setEstDesc(String estDesc) {
        this.estDesc = estDesc;
    }

    public Boolean getEstEst() {
        return estEst;
    }

    public void setEstEst(Boolean estEst) {
        this.estEst = estEst;
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
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefEstilo)) {
            return false;
        }
        RefEstilo other = (RefEstilo) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.RefEstilo[ estId=" + estId + " ]";
    }
    
}
