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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "prd_estampa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrdEstampa.findAll", query = "SELECT p FROM PrdEstampa p"),
    @NamedQuery(name = "PrdEstampa.findByEtmId", query = "SELECT p FROM PrdEstampa p WHERE p.etmId = :etmId"),
    @NamedQuery(name = "PrdEstampa.findByEtmNombre", query = "SELECT p FROM PrdEstampa p WHERE p.etmNombre = :etmNombre"),
    @NamedQuery(name = "PrdEstampa.findByEtmDesc", query = "SELECT p FROM PrdEstampa p WHERE p.etmDesc = :etmDesc"),
    @NamedQuery(name = "PrdEstampa.findByEtmPrecio", query = "SELECT p FROM PrdEstampa p WHERE p.etmPrecio = :etmPrecio"),
    @NamedQuery(name = "PrdEstampa.findByEtmEst", query = "SELECT p FROM PrdEstampa p WHERE p.etmEst = :etmEst"),
    @NamedQuery(name = "PrdEstampa.findByIndversion", query = "SELECT p FROM PrdEstampa p WHERE p.indversion = :indversion")})
public class PrdEstampa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "etm_id")
    private Long etmId;
    @Size(max = 100)
    @Column(name = "etm_nombre")
    private String etmNombre;
    @Size(max = 2147483647)
    @Column(name = "etm_desc")
    private String etmDesc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "etm_precio")
    private BigDecimal etmPrecio;
    @Column(name = "etm_est")
    private Boolean etmEst;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "etmId")
    private List<PrdImgxest> prdImgxestList;
    @OneToMany(mappedBy = "etmId")
    private List<VntEstxvn> vntEstxvnList;
    @JoinColumn(name = "rlfr_id", referencedColumnName = "rlfr_id")
    @ManyToOne
    private SysRolxfrn rlfrId;
    @JoinColumn(name = "tme_id", referencedColumnName = "tme_id")
    @ManyToOne
    private PrdTemaest tmeId;

    public PrdEstampa() {
    }

    public PrdEstampa(Long etmId) {
        this.etmId = etmId;
    }

    public Long getEtmId() {
        return etmId;
    }

    public void setEtmId(Long etmId) {
        this.etmId = etmId;
    }

    public String getEtmNombre() {
        return etmNombre;
    }

    public void setEtmNombre(String etmNombre) {
        this.etmNombre = etmNombre;
    }

    public String getEtmDesc() {
        return etmDesc;
    }

    public void setEtmDesc(String etmDesc) {
        this.etmDesc = etmDesc;
    }

    public BigDecimal getEtmPrecio() {
        return etmPrecio;
    }

    public void setEtmPrecio(BigDecimal etmPrecio) {
        this.etmPrecio = etmPrecio;
    }

    public Boolean getEtmEst() {
        return etmEst;
    }

    public void setEtmEst(Boolean etmEst) {
        this.etmEst = etmEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<PrdImgxest> getPrdImgxestList() {
        return prdImgxestList;
    }

    public void setPrdImgxestList(List<PrdImgxest> prdImgxestList) {
        this.prdImgxestList = prdImgxestList;
    }

    @XmlTransient
    public List<VntEstxvn> getVntEstxvnList() {
        return vntEstxvnList;
    }

    public void setVntEstxvnList(List<VntEstxvn> vntEstxvnList) {
        this.vntEstxvnList = vntEstxvnList;
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
        hash += (etmId != null ? etmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdEstampa)) {
            return false;
        }
        PrdEstampa other = (PrdEstampa) object;
        if ((this.etmId == null && other.etmId != null) || (this.etmId != null && !this.etmId.equals(other.etmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.PrdEstampa[ etmId=" + etmId + " ]";
    }

    /**
     * @return the tmeId
     */
    public PrdTemaest getTmeId() {
        return tmeId;
    }

    /**
     * @param tmeId the tmeId to set
     */
    public void setTmeId(PrdTemaest tmeId) {
        this.tmeId = tmeId;
    }

}
