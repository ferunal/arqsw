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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "prd_imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrdImagen.findAll", query = "SELECT p FROM PrdImagen p"),
    @NamedQuery(name = "PrdImagen.findByImgId", query = "SELECT p FROM PrdImagen p WHERE p.imgId = :imgId"),
    @NamedQuery(name = "PrdImagen.findByImgNombre", query = "SELECT p FROM PrdImagen p WHERE p.imgNombre = :imgNombre"),
    @NamedQuery(name = "PrdImagen.findByImgDesc", query = "SELECT p FROM PrdImagen p WHERE p.imgDesc = :imgDesc"),
    @NamedQuery(name = "PrdImagen.findByImgRuta", query = "SELECT p FROM PrdImagen p WHERE p.imgRuta = :imgRuta"),
    @NamedQuery(name = "PrdImagen.findByImgEst", query = "SELECT p FROM PrdImagen p WHERE p.imgEst = :imgEst"),
    @NamedQuery(name = "PrdImagen.findByIndversion", query = "SELECT p FROM PrdImagen p WHERE p.indversion = :indversion")})
public class PrdImagen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "img_id")
    private Long imgId;
    @Size(max = 100)
    @Column(name = "img_nombre")
    private String imgNombre;
    @Size(max = 2147483647)
    @Column(name = "img_desc")
    private String imgDesc;
    @Size(max = 800)
    @Column(name = "img_ruta")
    private String imgRuta;
    @Column(name = "img_est")
    private Boolean imgEst;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "imgId")
    private List<PrdImgxest> prdImgxestList;

    public PrdImagen() {
    }

    public PrdImagen(Long imgId) {
        this.imgId = imgId;
    }

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public String getImgNombre() {
        return imgNombre;
    }

    public void setImgNombre(String imgNombre) {
        this.imgNombre = imgNombre;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public String getImgRuta() {
        return imgRuta;
    }

    public void setImgRuta(String imgRuta) {
        this.imgRuta = imgRuta;
    }

    public Boolean getImgEst() {
        return imgEst;
    }

    public void setImgEst(Boolean imgEst) {
        this.imgEst = imgEst;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imgId != null ? imgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrdImagen)) {
            return false;
        }
        PrdImagen other = (PrdImagen) object;
        if ((this.imgId == null && other.imgId != null) || (this.imgId != null && !this.imgId.equals(other.imgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.PrdImagen[ imgId=" + imgId + " ]";
    }
    
}
