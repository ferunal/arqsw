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
@Table(name = "vnt_mdpxfact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VntMdpxfact.findAll", query = "SELECT v FROM VntMdpxfact v"),
    @NamedQuery(name = "VntMdpxfact.findByMdxfId", query = "SELECT v FROM VntMdpxfact v WHERE v.mdxfId = :mdxfId"),
    @NamedQuery(name = "VntMdpxfact.findByMdxfValor", query = "SELECT v FROM VntMdpxfact v WHERE v.mdxfValor = :mdxfValor"),
    @NamedQuery(name = "VntMdpxfact.findByMdxfEst", query = "SELECT v FROM VntMdpxfact v WHERE v.mdxfEst = :mdxfEst"),
    @NamedQuery(name = "VntMdpxfact.findByIndversion", query = "SELECT v FROM VntMdpxfact v WHERE v.indversion = :indversion")})
public class VntMdpxfact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mdxf_id")
    private Long mdxfId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mdxf_valor")
    private BigDecimal mdxfValor;
    @Column(name = "mdxf_est")
    private Boolean mdxfEst;
    @Column(name = "indversion")
    private Integer indversion;
    @JoinColumn(name = "detf_id", referencedColumnName = "detf_id")
    @ManyToOne
    private SysDetallefnr detfId;
    @JoinColumn(name = "fac_id", referencedColumnName = "fac_id")
    @ManyToOne
    private VntFactura facId;

    public VntMdpxfact() {
    }

    public VntMdpxfact(Long mdxfId) {
        this.mdxfId = mdxfId;
    }

    public Long getMdxfId() {
        return mdxfId;
    }

    public void setMdxfId(Long mdxfId) {
        this.mdxfId = mdxfId;
    }

    public BigDecimal getMdxfValor() {
        return mdxfValor;
    }

    public void setMdxfValor(BigDecimal mdxfValor) {
        this.mdxfValor = mdxfValor;
    }

    public Boolean getMdxfEst() {
        return mdxfEst;
    }

    public void setMdxfEst(Boolean mdxfEst) {
        this.mdxfEst = mdxfEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public SysDetallefnr getDetfId() {
        return detfId;
    }

    public void setDetfId(SysDetallefnr detfId) {
        this.detfId = detfId;
    }

    public VntFactura getFacId() {
        return facId;
    }

    public void setFacId(VntFactura facId) {
        this.facId = facId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mdxfId != null ? mdxfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VntMdpxfact)) {
            return false;
        }
        VntMdpxfact other = (VntMdpxfact) object;
        if ((this.mdxfId == null && other.mdxfId != null) || (this.mdxfId != null && !this.mdxfId.equals(other.mdxfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.VntMdpxfact[ mdxfId=" + mdxfId + " ]";
    }
    
}
