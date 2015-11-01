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
@Table(name = "sys_menuprin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysMenuprin.findAll", query = "SELECT s FROM SysMenuprin s"),
    @NamedQuery(name = "SysMenuprin.findByMenId", query = "SELECT s FROM SysMenuprin s WHERE s.menId = :menId"),
    @NamedQuery(name = "SysMenuprin.findByMenNombre", query = "SELECT s FROM SysMenuprin s WHERE s.menNombre = :menNombre"),
    @NamedQuery(name = "SysMenuprin.findByMenDesc", query = "SELECT s FROM SysMenuprin s WHERE s.menDesc = :menDesc"),
    @NamedQuery(name = "SysMenuprin.findByMenEst", query = "SELECT s FROM SysMenuprin s WHERE s.menEst = :menEst"),
    @NamedQuery(name = "SysMenuprin.findByIndversion", query = "SELECT s FROM SysMenuprin s WHERE s.indversion = :indversion"),
    @NamedQuery(name = "SysMenuprin.findByMenOrden", query = "SELECT s FROM SysMenuprin s WHERE s.menOrden = :menOrden")})
public class SysMenuprin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "men_id")
    private Integer menId;
    @Column(name = "men_nombre")
    private String menNombre;
    @Column(name = "men_desc")
    private String menDesc;
    @Column(name = "men_est")
    private Boolean menEst;
    @Column(name = "indversion")
    private Integer indversion;
    @Column(name = "men_orden")
    private Integer menOrden;
    @OneToMany(mappedBy = "menId")
    private List<SysModulos> sysModulosList;

    public SysMenuprin() {
    }

    public SysMenuprin(Integer menId) {
        this.menId = menId;
    }

    public Integer getMenId() {
        return menId;
    }

    public void setMenId(Integer menId) {
        this.menId = menId;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public String getMenDesc() {
        return menDesc;
    }

    public void setMenDesc(String menDesc) {
        this.menDesc = menDesc;
    }

    public Boolean getMenEst() {
        return menEst;
    }

    public void setMenEst(Boolean menEst) {
        this.menEst = menEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public Integer getMenOrden() {
        return menOrden;
    }

    public void setMenOrden(Integer menOrden) {
        this.menOrden = menOrden;
    }

    @XmlTransient
    public List<SysModulos> getSysModulosList() {
        return sysModulosList;
    }

    public void setSysModulosList(List<SysModulos> sysModulosList) {
        this.sysModulosList = sysModulosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menId != null ? menId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysMenuprin)) {
            return false;
        }
        SysMenuprin other = (SysMenuprin) object;
        if ((this.menId == null && other.menId != null) || (this.menId != null && !this.menId.equals(other.menId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.SysMenuprin[ menId=" + menId + " ]";
    }
    
}
