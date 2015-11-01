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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "sys_submodxrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysSubmodxrol.findAll", query = "SELECT s FROM SysSubmodxrol s"),
    @NamedQuery(name = "SysSubmodxrol.findBySbrlId", query = "SELECT s FROM SysSubmodxrol s WHERE s.sbrlId = :sbrlId"),
    @NamedQuery(name = "SysSubmodxrol.findBySbrlEstado", query = "SELECT s FROM SysSubmodxrol s WHERE s.sbrlEstado = :sbrlEstado")})
public class SysSubmodxrol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sbrl_id")
    private Integer sbrlId;
    @Column(name = "sbrl_estado")
    private Boolean sbrlEstado;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private SysRol rolId;
    @JoinColumn(name = "sub_id", referencedColumnName = "sub_id")
    @ManyToOne
    private SysSubmodulo subId;

    public SysSubmodxrol() {
    }

    public SysSubmodxrol(Integer sbrlId) {
        this.sbrlId = sbrlId;
    }

    public Integer getSbrlId() {
        return sbrlId;
    }

    public void setSbrlId(Integer sbrlId) {
        this.sbrlId = sbrlId;
    }

    public Boolean getSbrlEstado() {
        return sbrlEstado;
    }

    public void setSbrlEstado(Boolean sbrlEstado) {
        this.sbrlEstado = sbrlEstado;
    }

    public SysRol getRolId() {
        return rolId;
    }

    public void setRolId(SysRol rolId) {
        this.rolId = rolId;
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
        hash += (sbrlId != null ? sbrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysSubmodxrol)) {
            return false;
        }
        SysSubmodxrol other = (SysSubmodxrol) object;
        if ((this.sbrlId == null && other.sbrlId != null) || (this.sbrlId != null && !this.sbrlId.equals(other.sbrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.SysSubmodxrol[ sbrlId=" + sbrlId + " ]";
    }
    
}
