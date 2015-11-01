/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unniminuto.lchacon.estampateem.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "vnt_detfactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VntDetfactura.findAll", query = "SELECT v FROM VntDetfactura v"),
    @NamedQuery(name = "VntDetfactura.findByDetfacId", query = "SELECT v FROM VntDetfactura v WHERE v.detfacId = :detfacId"),
    @NamedQuery(name = "VntDetfactura.findByDetfacValor", query = "SELECT v FROM VntDetfactura v WHERE v.detfacValor = :detfacValor"),
    @NamedQuery(name = "VntDetfactura.findByDetfacTextadd", query = "SELECT v FROM VntDetfactura v WHERE v.detfacTextadd = :detfacTextadd"),
    @NamedQuery(name = "VntDetfactura.findByDetfacValrtxtadd", query = "SELECT v FROM VntDetfactura v WHERE v.detfacValrtxtadd = :detfacValrtxtadd"),
    @NamedQuery(name = "VntDetfactura.findByIndversion", query = "SELECT v FROM VntDetfactura v WHERE v.indversion = :indversion"),
    @NamedQuery(name = "VntDetfactura.findByDetfacCantidad", query = "SELECT v FROM VntDetfactura v WHERE v.detfacCantidad = :detfacCantidad")})
public class VntDetfactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "detfac_id")
    private Long detfacId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "detfac_valor")
    private BigDecimal detfacValor;
    @Column(name = "detfac_textadd")
    private Boolean detfacTextadd;
    @Column(name = "detfac_valrtxtadd")
    private BigDecimal detfacValrtxtadd;
    @Column(name = "indversion")
    private Integer indversion;
    @Column(name = "detfac_cantidad")
    private Integer detfacCantidad;
    @JoinColumn(name = "cam_id", referencedColumnName = "cam_id")
    @ManyToOne
    private PrdCamiseta camId;
    @JoinColumn(name = "fac_id", referencedColumnName = "fac_id")
    @ManyToOne
    private VntFactura facId;
    @OneToMany(mappedBy = "detfacId")
    private List<VntEstxvn> vntEstxvnList;

    public VntDetfactura() {
    }

    public VntDetfactura(Long detfacId) {
        this.detfacId = detfacId;
    }

    public Long getDetfacId() {
        return detfacId;
    }

    public void setDetfacId(Long detfacId) {
        this.detfacId = detfacId;
    }

    public BigDecimal getDetfacValor() {
        return detfacValor;
    }

    public void setDetfacValor(BigDecimal detfacValor) {
        this.detfacValor = detfacValor;
    }

    public Boolean getDetfacTextadd() {
        return detfacTextadd;
    }

    public void setDetfacTextadd(Boolean detfacTextadd) {
        this.detfacTextadd = detfacTextadd;
    }

    public BigDecimal getDetfacValrtxtadd() {
        return detfacValrtxtadd;
    }

    public void setDetfacValrtxtadd(BigDecimal detfacValrtxtadd) {
        this.detfacValrtxtadd = detfacValrtxtadd;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public Integer getDetfacCantidad() {
        return detfacCantidad;
    }

    public void setDetfacCantidad(Integer detfacCantidad) {
        this.detfacCantidad = detfacCantidad;
    }

    public PrdCamiseta getCamId() {
        return camId;
    }

    public void setCamId(PrdCamiseta camId) {
        this.camId = camId;
    }

    public VntFactura getFacId() {
        return facId;
    }

    public void setFacId(VntFactura facId) {
        this.facId = facId;
    }

    @XmlTransient
    public List<VntEstxvn> getVntEstxvnList() {
        return vntEstxvnList;
    }

    public void setVntEstxvnList(List<VntEstxvn> vntEstxvnList) {
        this.vntEstxvnList = vntEstxvnList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detfacId != null ? detfacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VntDetfactura)) {
            return false;
        }
        VntDetfactura other = (VntDetfactura) object;
        if ((this.detfacId == null && other.detfacId != null) || (this.detfacId != null && !this.detfacId.equals(other.detfacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.VntDetfactura[ detfacId=" + detfacId + " ]";
    }
    
}
