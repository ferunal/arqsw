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
 * @author fercris
 */
@Entity
@Table(name = "sys_modulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysModulos.findAll", query = "SELECT s FROM SysModulos s"),
    @NamedQuery(name = "SysModulos.findByProcId", query = "SELECT s FROM SysModulos s WHERE s.procId = :procId"),
    @NamedQuery(name = "SysModulos.findByProcNombre", query = "SELECT s FROM SysModulos s WHERE s.procNombre = :procNombre"),
    @NamedQuery(name = "SysModulos.findByProcDesc", query = "SELECT s FROM SysModulos s WHERE s.procDesc = :procDesc"),
    @NamedQuery(name = "SysModulos.findByProcEstado", query = "SELECT s FROM SysModulos s WHERE s.procEstado = :procEstado"),
    @NamedQuery(name = "SysModulos.findByIndversion", query = "SELECT s FROM SysModulos s WHERE s.indversion = :indversion"),
    @NamedQuery(name = "SysModulos.modulosXMenu", query = "SELECT s FROM SysModulos s JOIN s.menId m WHERE m.menId = :menId AND s.procEstado = :procEstado")
})
public class SysModulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "proc_id")
    private Integer procId;
    @Size(max = 250)
    @Column(name = "proc_nombre")
    private String procNombre;
    @Size(max = 2147483647)
    @Column(name = "proc_desc")
    private String procDesc;
    @Column(name = "proc_estado")
    private Boolean procEstado;
    @Column(name = "indversion")
    private Integer indversion;
    @JoinColumn(name = "men_id", referencedColumnName = "men_id")
    @ManyToOne
    private SysMenuprin menId;
    @OneToMany(mappedBy = "procId")
    private List<SysSubmodulo> sysSubmoduloList;

    public SysModulos() {
    }

    public SysModulos(Integer procId) {
        this.procId = procId;
    }

    public Integer getProcId() {
        return procId;
    }

    public void setProcId(Integer procId) {
        this.procId = procId;
    }

    public String getProcNombre() {
        return procNombre;
    }

    public void setProcNombre(String procNombre) {
        this.procNombre = procNombre;
    }

    public String getProcDesc() {
        return procDesc;
    }

    public void setProcDesc(String procDesc) {
        this.procDesc = procDesc;
    }

    public Boolean getProcEstado() {
        return procEstado;
    }

    public void setProcEstado(Boolean procEstado) {
        this.procEstado = procEstado;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public SysMenuprin getMenId() {
        return menId;
    }

    public void setMenId(SysMenuprin menId) {
        this.menId = menId;
    }

    @XmlTransient
    public List<SysSubmodulo> getSysSubmoduloList() {
        return sysSubmoduloList;
    }

    public void setSysSubmoduloList(List<SysSubmodulo> sysSubmoduloList) {
        this.sysSubmoduloList = sysSubmoduloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procId != null ? procId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysModulos)) {
            return false;
        }
        SysModulos other = (SysModulos) object;
        if ((this.procId == null && other.procId != null) || (this.procId != null && !this.procId.equals(other.procId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.SysModulos[ procId=" + procId + " ]";
    }

}
