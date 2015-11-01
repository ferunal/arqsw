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
@Table(name = "prd_camiseta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrdCamiseta.findAll", query = "SELECT p FROM PrdCamiseta p"),
    @NamedQuery(name = "PrdCamiseta.findByCamId", query = "SELECT p FROM PrdCamiseta p WHERE p.camId = :camId"),
    @NamedQuery(name = "PrdCamiseta.findByCamEst", query = "SELECT p FROM PrdCamiseta p WHERE p.camEst = :camEst"),
    @NamedQuery(name = "PrdCamiseta.findByIndversion", query = "SELECT p FROM PrdCamiseta p WHERE p.indversion = :indversion"),
    @NamedQuery(name = "PrdCamiseta.findByCamPrecio", query = "SELECT p FROM PrdCamiseta p WHERE p.camPrecio = :camPrecio")})
public class PrdCamiseta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cam_id")
    private Long camId;
    @Column(name = "cam_est")
    private Boolean camEst;
    @Column(name = "indversion")
    private Integer indversion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cam_precio")
    private BigDecimal camPrecio;
    @OneToMany(mappedBy = "camId")
    private List<VntDetfactura> vntDetfacturaList;
    @JoinColumn(name = "clr_id", referencedColumnName = "clr_id")
    @ManyToOne
    private RefColor clrId;
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne
    private RefEstilo estId;
    @JoinColumn(name = "mat_id", referencedColumnName = "mat_id")
    @ManyToOne
    private RefMaterial matId;
    @JoinColumn(name = "tla_id", referencedColumnName = "tla_id")
    @ManyToOne
    private RefTalla tlaId;

    public PrdCamiseta() {
    }

    public PrdCamiseta(Long camId) {
        this.camId = camId;
    }

    public Long getCamId() {
        return camId;
    }

    public void setCamId(Long camId) {
        this.camId = camId;
    }

    public Boolean getCamEst() {
        return camEst;
    }

    public void setCamEst(Boolean camEst) {
        this.camEst = camEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public BigDecimal getCamPrecio() {
        return camPrecio;
    }

    public void setCamPrecio(BigDecimal camPrecio) {
        this.camPrecio = camPrecio;
    }

    @XmlTransient
    public List<VntDetfactura> getVntDetfacturaList() {
        return vntDetfacturaList;
    }

    public void setVntDetfacturaList(List<VntDetfactura> vntDetfacturaList) {
        this.vntDetfacturaList = vntDetfacturaList;
    }

    public RefColor getClrId() {
        return clrId;
    }

    public void setClrId(RefColor clrId) {
        this.clrId = clrId;
    }

    public RefEstilo getEstId() {
        return estId;
    }

    public void setEstId(RefEstilo estId) {
        this.estId = estId;
    }

    public RefMaterial getMatId() {
        return matId;
    }

    public void setMatId(RefMaterial matId) {
        this.matId = matId;
    }

    public RefTalla getTlaId() {
        return tlaId;
    }

    public void setTlaId(RefTalla tlaId) {
        this.tlaId = tlaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (camId != null ? camId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdCamiseta)) {
            return false;
        }
        PrdCamiseta other = (PrdCamiseta) object;
        if ((this.camId == null && other.camId != null) || (this.camId != null && !this.camId.equals(other.camId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.PrdCamiseta[ camId=" + camId + " ]";
    }
    
}
