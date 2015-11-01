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
@Table(name = "ref_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefMaterial.findAll", query = "SELECT r FROM RefMaterial r"),
    @NamedQuery(name = "RefMaterial.findByMatId", query = "SELECT r FROM RefMaterial r WHERE r.matId = :matId"),
    @NamedQuery(name = "RefMaterial.findByMatNombre", query = "SELECT r FROM RefMaterial r WHERE r.matNombre = :matNombre"),
    @NamedQuery(name = "RefMaterial.findByMatDesc", query = "SELECT r FROM RefMaterial r WHERE r.matDesc = :matDesc"),
    @NamedQuery(name = "RefMaterial.findByMatEst", query = "SELECT r FROM RefMaterial r WHERE r.matEst = :matEst"),
    @NamedQuery(name = "RefMaterial.findByIndversion", query = "SELECT r FROM RefMaterial r WHERE r.indversion = :indversion")})
public class RefMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mat_id")
    private Integer matId;
    @Column(name = "mat_nombre")
    private String matNombre;
    @Column(name = "mat_desc")
    private String matDesc;
    @Column(name = "mat_est")
    private Boolean matEst;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "matId")
    private List<PrdCamiseta> prdCamisetaList;

    public RefMaterial() {
    }

    public RefMaterial(Integer matId) {
        this.matId = matId;
    }

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    public String getMatNombre() {
        return matNombre;
    }

    public void setMatNombre(String matNombre) {
        this.matNombre = matNombre;
    }

    public String getMatDesc() {
        return matDesc;
    }

    public void setMatDesc(String matDesc) {
        this.matDesc = matDesc;
    }

    public Boolean getMatEst() {
        return matEst;
    }

    public void setMatEst(Boolean matEst) {
        this.matEst = matEst;
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
        hash += (matId != null ? matId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefMaterial)) {
            return false;
        }
        RefMaterial other = (RefMaterial) object;
        if ((this.matId == null && other.matId != null) || (this.matId != null && !this.matId.equals(other.matId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.RefMaterial[ matId=" + matId + " ]";
    }
    
}
