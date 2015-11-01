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
@Table(name = "prd_imgxest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrdImgxest.findAll", query = "SELECT p FROM PrdImgxest p"),
    @NamedQuery(name = "PrdImgxest.findByImxeId", query = "SELECT p FROM PrdImgxest p WHERE p.imxeId = :imxeId"),
    @NamedQuery(name = "PrdImgxest.findByImxeEst", query = "SELECT p FROM PrdImgxest p WHERE p.imxeEst = :imxeEst"),
    @NamedQuery(name = "PrdImgxest.findByIndversion", query = "SELECT p FROM PrdImgxest p WHERE p.indversion = :indversion")})
public class PrdImgxest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "imxe_id")
    private Long imxeId;
    @Column(name = "imxe_est")
    private Boolean imxeEst;
    @Column(name = "indversion")
    private Integer indversion;
    @JoinColumn(name = "etm_id", referencedColumnName = "etm_id")
    @ManyToOne
    private PrdEstampa etmId;
    @JoinColumn(name = "img_id", referencedColumnName = "img_id")
    @ManyToOne
    private PrdImagen imgId;

    public PrdImgxest() {
    }

    public PrdImgxest(Long imxeId) {
        this.imxeId = imxeId;
    }

    public Long getImxeId() {
        return imxeId;
    }

    public void setImxeId(Long imxeId) {
        this.imxeId = imxeId;
    }

    public Boolean getImxeEst() {
        return imxeEst;
    }

    public void setImxeEst(Boolean imxeEst) {
        this.imxeEst = imxeEst;
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

    public PrdImagen getImgId() {
        return imgId;
    }

    public void setImgId(PrdImagen imgId) {
        this.imgId = imgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imxeId != null ? imxeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdImgxest)) {
            return false;
        }
        PrdImgxest other = (PrdImgxest) object;
        if ((this.imxeId == null && other.imxeId != null) || (this.imxeId != null && !this.imxeId.equals(other.imxeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.PrdImgxest[ imxeId=" + imxeId + " ]";
    }
    
}
