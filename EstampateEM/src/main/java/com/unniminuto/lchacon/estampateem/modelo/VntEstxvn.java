/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unniminuto.lchacon.estampateem.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "vnt_estxvn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VntEstxvn.findAll", query = "SELECT v FROM VntEstxvn v"),
    @NamedQuery(name = "VntEstxvn.findByExvId", query = "SELECT v FROM VntEstxvn v WHERE v.exvId = :exvId"),
    @NamedQuery(name = "VntEstxvn.findByExvValor", query = "SELECT v FROM VntEstxvn v WHERE v.exvValor = :exvValor"),
    @NamedQuery(name = "VntEstxvn.findByExvEst", query = "SELECT v FROM VntEstxvn v WHERE v.exvEst = :exvEst"),
    @NamedQuery(name = "VntEstxvn.findByIndversion", query = "SELECT v FROM VntEstxvn v WHERE v.indversion = :indversion")})
public class VntEstxvn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "exv_id")
    private Long exvId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "exv_valor")
    private BigDecimal exvValor;
    @Column(name = "exv_est")
    private Boolean exvEst;
    @Column(name = "indversion")
    private Integer indversion;
    @JoinColumn(name = "etm_id", referencedColumnName = "etm_id")
    @ManyToOne
    private PrdEstampa etmId;
    @JoinColumn(name = "detfac_id", referencedColumnName = "detfac_id")
    @ManyToOne
    private VntDetfactura detfacId;

    public VntEstxvn() {
    }

    public VntEstxvn(Long exvId) {
        this.exvId = exvId;
    }

    public Long getExvId() {
        return exvId;
    }

    public void setExvId(Long exvId) {
        this.exvId = exvId;
    }

    public BigDecimal getExvValor() {
        return exvValor;
    }

    public void setExvValor(BigDecimal exvValor) {
        this.exvValor = exvValor;
    }

    public Boolean getExvEst() {
        return exvEst;
    }

    public void setExvEst(Boolean exvEst) {
        this.exvEst = exvEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public PrdEstampa getEtmId() {
        return etmId;
    }

    public void setEtmId(PrdEstampa etmId) {
        this.etmId = etmId;
    }

    public VntDetfactura getDetfacId() {
        return detfacId;
    }

    public void setDetfacId(VntDetfactura detfacId) {
        this.detfacId = detfacId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exvId != null ? exvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VntEstxvn)) {
            return false;
        }
        VntEstxvn other = (VntEstxvn) object;
        if ((this.exvId == null && other.exvId != null) || (this.exvId != null && !this.exvId.equals(other.exvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.VntEstxvn[ exvId=" + exvId + " ]";
    }
    
}
