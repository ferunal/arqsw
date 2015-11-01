/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unniminuto.lchacon.estampateem.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "sys_submodxfrn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysSubmodxfrn.findAll", query = "SELECT s FROM SysSubmodxfrn s"),
    @NamedQuery(name = "SysSubmodxfrn.findBySbfrId", query = "SELECT s FROM SysSubmodxfrn s WHERE s.sbfrId = :sbfrId"),
    @NamedQuery(name = "SysSubmodxfrn.findBySbfrEstado", query = "SELECT s FROM SysSubmodxfrn s WHERE s.sbfrEstado = :sbfrEstado")})
public class SysSubmodxfrn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sbfr_id")
    private Integer sbfrId;
    @Column(name = "sbfr_estado")
    private Boolean sbfrEstado;
    @JoinColumn(name = "frn_id", referencedColumnName = "frn_id")
    @ManyToOne
    private SysFuncionario frnId;
    @JoinColumn(name = "sub_id", referencedColumnName = "sub_id")
    @ManyToOne
    private SysSubmodulo subId;

    public SysSubmodxfrn() {
    }

    public SysSubmodxfrn(Integer sbfrId) {
        this.sbfrId = sbfrId;
    }

    public Integer getSbfrId() {
        return sbfrId;
    }

    public void setSbfrId(Integer sbfrId) {
        this.sbfrId = sbfrId;
    }

    public Boolean getSbfrEstado() {
        return sbfrEstado;
    }

    public void setSbfrEstado(Boolean sbfrEstado) {
        this.sbfrEstado = sbfrEstado;
    }

    public SysFuncionario getFrnId() {
        return frnId;
    }

    public void setFrnId(SysFuncionario frnId) {
        this.frnId = frnId;
    }

    public SysSubmodulo getSubId() {
        return subId;
    }

    public void setSubId(SysSubmodulo subId) {
        this.subId = subId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sbfrId != null ? sbfrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysSubmodxfrn)) {
            return false;
        }
        SysSubmodxfrn other = (SysSubmodxfrn) object;
        if ((this.sbfrId == null && other.sbfrId != null) || (this.sbfrId != null && !this.sbfrId.equals(other.sbfrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.SysSubmodxfrn[ sbfrId=" + sbfrId + " ]";
    }
    
}
