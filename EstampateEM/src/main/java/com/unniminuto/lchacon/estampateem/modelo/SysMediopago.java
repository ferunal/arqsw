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
@Table(name = "sys_mediopago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysMediopago.findAll", query = "SELECT s FROM SysMediopago s"),
    @NamedQuery(name = "SysMediopago.findByMdpId", query = "SELECT s FROM SysMediopago s WHERE s.mdpId = :mdpId"),
    @NamedQuery(name = "SysMediopago.findByMdpNombre", query = "SELECT s FROM SysMediopago s WHERE s.mdpNombre = :mdpNombre"),
    @NamedQuery(name = "SysMediopago.findByMdpDesc", query = "SELECT s FROM SysMediopago s WHERE s.mdpDesc = :mdpDesc"),
    @NamedQuery(name = "SysMediopago.findByMdpEst", query = "SELECT s FROM SysMediopago s WHERE s.mdpEst = :mdpEst")})
public class SysMediopago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mdp_id")
    private Integer mdpId;
    @Size(max = 100)
    @Column(name = "mdp_nombre")
    private String mdpNombre;
    @Size(max = 2147483647)
    @Column(name = "mdp_desc")
    private String mdpDesc;
    @Column(name = "mdp_est")
    private Boolean mdpEst;
    @OneToMany(mappedBy = "mdpId")
    private List<SysDetallefnr> sysDetallefnrList;

    public SysMediopago() {
    }

    public SysMediopago(Integer mdpId) {
        this.mdpId = mdpId;
    }

    public Integer getMdpId() {
        return mdpId;
    }

    public void setMdpId(Integer mdpId) {
        this.mdpId = mdpId;
    }

    public String getMdpNombre() {
        return mdpNombre;
    }

    public void setMdpNombre(String mdpNombre) {
        this.mdpNombre = mdpNombre;
    }

    public String getMdpDesc() {
        return mdpDesc;
    }

    public void setMdpDesc(String mdpDesc) {
        this.mdpDesc = mdpDesc;
    }

    public Boolean getMdpEst() {
        return mdpEst;
    }

    public void setMdpEst(Boolean mdpEst) {
        this.mdpEst = mdpEst;
    }

    @XmlTransient
    public List<SysDetallefnr> getSysDetallefnrList() {
        return sysDetallefnrList;
    }

    public void setSysDetallefnrList(List<SysDetallefnr> sysDetallefnrList) {
        this.sysDetallefnrList = sysDetallefnrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mdpId != null ? mdpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysMediopago)) {
            return false;
        }
        SysMediopago other = (SysMediopago) object;
        if ((this.mdpId == null && other.mdpId != null) || (this.mdpId != null && !this.mdpId.equals(other.mdpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.SysMediopago[ mdpId=" + mdpId + " ]";
    }
    
}
