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
@Table(name = "ref_color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RefColor.findAll", query = "SELECT r FROM RefColor r"),
    @NamedQuery(name = "RefColor.findByClrId", query = "SELECT r FROM RefColor r WHERE r.clrId = :clrId"),
    @NamedQuery(name = "RefColor.findByClrNombre", query = "SELECT r FROM RefColor r WHERE r.clrNombre = :clrNombre"),
    @NamedQuery(name = "RefColor.findByClrDesc", query = "SELECT r FROM RefColor r WHERE r.clrDesc = :clrDesc"),
    @NamedQuery(name = "RefColor.findByClrEst", query = "SELECT r FROM RefColor r WHERE r.clrEst = :clrEst"),
    @NamedQuery(name = "RefColor.findByIndversion", query = "SELECT r FROM RefColor r WHERE r.indversion = :indversion")})
public class RefColor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clr_id")
    private Integer clrId;
    @Size(max = 100)
    @Column(name = "clr_nombre")
    private String clrNombre;
    @Size(max = 2147483647)
    @Column(name = "clr_desc")
    private String clrDesc;
    @Column(name = "clr_est")
    private Boolean clrEst;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "clrId")
    private List<PrdCamiseta> prdCamisetaList;

    public RefColor() {
    }

    public RefColor(Integer clrId) {
        this.clrId = clrId;
    }

    public Integer getClrId() {
        return clrId;
    }

    public void setClrId(Integer clrId) {
        this.clrId = clrId;
    }

    public String getClrNombre() {
        return clrNombre;
    }

    public void setClrNombre(String clrNombre) {
        this.clrNombre = clrNombre;
    }

    public String getClrDesc() {
        return clrDesc;
    }

    public void setClrDesc(String clrDesc) {
        this.clrDesc = clrDesc;
    }

    public Boolean getClrEst() {
        return clrEst;
    }

    public void setClrEst(Boolean clrEst) {
        this.clrEst = clrEst;
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
        hash += (clrId != null ? clrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RefColor)) {
            return false;
        }
        RefColor other = (RefColor) object;
        if ((this.clrId == null && other.clrId != null) || (this.clrId != null && !this.clrId.equals(other.clrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.RefColor[ clrId=" + clrId + " ]";
    }
    
}
