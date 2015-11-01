/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unniminuto.lchacon.estampateem.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "vnt_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VntFactura.findAll", query = "SELECT v FROM VntFactura v"),
    @NamedQuery(name = "VntFactura.findByFacId", query = "SELECT v FROM VntFactura v WHERE v.facId = :facId"),
    @NamedQuery(name = "VntFactura.findByFacFechacre", query = "SELECT v FROM VntFactura v WHERE v.facFechacre = :facFechacre"),
    @NamedQuery(name = "VntFactura.findByFacValorneto", query = "SELECT v FROM VntFactura v WHERE v.facValorneto = :facValorneto"),
    @NamedQuery(name = "VntFactura.findByFacImpuesto", query = "SELECT v FROM VntFactura v WHERE v.facImpuesto = :facImpuesto"),
    @NamedQuery(name = "VntFactura.findByFacValortotal", query = "SELECT v FROM VntFactura v WHERE v.facValortotal = :facValortotal"),
    @NamedQuery(name = "VntFactura.findByFacPorcimp", query = "SELECT v FROM VntFactura v WHERE v.facPorcimp = :facPorcimp"),
    @NamedQuery(name = "VntFactura.findByFacPrefactura", query = "SELECT v FROM VntFactura v WHERE v.facPrefactura = :facPrefactura"),
    @NamedQuery(name = "VntFactura.findByIndversion", query = "SELECT v FROM VntFactura v WHERE v.indversion = :indversion")})
public class VntFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fac_id")
    private Long facId;
    @Column(name = "fac_fechacre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date facFechacre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fac_valorneto")
    private BigDecimal facValorneto;
    @Column(name = "fac_impuesto")
    private BigDecimal facImpuesto;
    @Column(name = "fac_valortotal")
    private BigDecimal facValortotal;
    @Column(name = "fac_porcimp")
    private BigDecimal facPorcimp;
    @Column(name = "fac_prefactura")
    private Boolean facPrefactura;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "facId")
    private List<VntDetfactura> vntDetfacturaList;
    @OneToMany(mappedBy = "facId")
    private List<VntMdpxfact> vntMdpxfactList;
    @JoinColumn(name = "rlfr_id", referencedColumnName = "rlfr_id")
    @ManyToOne
    private SysRolxfrn rlfrId;

    public VntFactura() {
    }

    public VntFactura(Long facId) {
        this.facId = facId;
    }

    public Long getFacId() {
        return facId;
    }

    public void setFacId(Long facId) {
        this.facId = facId;
    }

    public Date getFacFechacre() {
        return facFechacre;
    }

    public void setFacFechacre(Date facFechacre) {
        this.facFechacre = facFechacre;
    }

    public BigDecimal getFacValorneto() {
        return facValorneto;
    }

    public void setFacValorneto(BigDecimal facValorneto) {
        this.facValorneto = facValorneto;
    }

    public BigDecimal getFacImpuesto() {
        return facImpuesto;
    }

    public void setFacImpuesto(BigDecimal facImpuesto) {
        this.facImpuesto = facImpuesto;
    }

    public BigDecimal getFacValortotal() {
        return facValortotal;
    }

    public void setFacValortotal(BigDecimal facValortotal) {
        this.facValortotal = facValortotal;
    }

    public BigDecimal getFacPorcimp() {
        return facPorcimp;
    }

    public void setFacPorcimp(BigDecimal facPorcimp) {
        this.facPorcimp = facPorcimp;
    }

    public Boolean getFacPrefactura() {
        return facPrefactura;
    }

    public void setFacPrefactura(Boolean facPrefactura) {
        this.facPrefactura = facPrefactura;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<VntDetfactura> getVntDetfacturaList() {
        return vntDetfacturaList;
    }

    public void setVntDetfacturaList(List<VntDetfactura> vntDetfacturaList) {
        this.vntDetfacturaList = vntDetfacturaList;
    }

    @XmlTransient
    public List<VntMdpxfact> getVntMdpxfactList() {
        return vntMdpxfactList;
    }

    public void setVntMdpxfactList(List<VntMdpxfact> vntMdpxfactList) {
        this.vntMdpxfactList = vntMdpxfactList;
    }

    public SysRolxfrn getRlfrId() {
        return rlfrId;
    }

    public void setRlfrId(SysRolxfrn rlfrId) {
        this.rlfrId = rlfrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facId != null ? facId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VntFactura)) {
            return false;
        }
        VntFactura other = (VntFactura) object;
        if ((this.facId == null && other.facId != null) || (this.facId != null && !this.facId.equals(other.facId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.VntFactura[ facId=" + facId + " ]";
    }
    
}
