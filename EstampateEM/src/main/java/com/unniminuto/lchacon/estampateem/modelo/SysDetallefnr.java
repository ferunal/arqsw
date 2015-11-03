/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unniminuto.lchacon.estampateem.modelo;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "sys_detallefnr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysDetallefnr.findAll", query = "SELECT s FROM SysDetallefnr s"),
    @NamedQuery(name = "SysDetallefnr.findByDetfId", query = "SELECT s FROM SysDetallefnr s WHERE s.detfId = :detfId"),
    @NamedQuery(name = "SysDetallefnr.findByDetfDireccion", query = "SELECT s FROM SysDetallefnr s WHERE s.detfDireccion = :detfDireccion"),
    @NamedQuery(name = "SysDetallefnr.findByDetfDireccion1", query = "SELECT s FROM SysDetallefnr s WHERE s.detfDireccion1 = :detfDireccion1"),
    @NamedQuery(name = "SysDetallefnr.findByDetfTelefono", query = "SELECT s FROM SysDetallefnr s WHERE s.detfTelefono = :detfTelefono"),
    @NamedQuery(name = "SysDetallefnr.findByDetfPais", query = "SELECT s FROM SysDetallefnr s WHERE s.detfPais = :detfPais"),
    @NamedQuery(name = "SysDetallefnr.findByDetfCiudad", query = "SELECT s FROM SysDetallefnr s WHERE s.detfCiudad = :detfCiudad"),
    @NamedQuery(name = "SysDetallefnr.findByDetfMdpnumero", query = "SELECT s FROM SysDetallefnr s WHERE s.detfMdpnumero = :detfMdpnumero"),
    @NamedQuery(name = "SysDetallefnr.findByDetfMdpdigitver", query = "SELECT s FROM SysDetallefnr s WHERE s.detfMdpdigitver = :detfMdpdigitver"),
    @NamedQuery(name = "SysDetallefnr.findByDetfEst", query = "SELECT s FROM SysDetallefnr s WHERE s.detfEst = :detfEst"),
    @NamedQuery(name = "SysDetallefnr.findByIndversion", query = "SELECT s FROM SysDetallefnr s WHERE s.indversion = :indversion")})
public class SysDetallefnr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "detf_id")
    private Long detfId;
    @Size(max = 2147483647)
    @Column(name = "detf_direccion")
    private String detfDireccion;
    @Size(max = 2147483647)
    @Column(name = "detf_direccion1")
    private String detfDireccion1;
    @Size(max = 50)
    @Column(name = "detf_telefono")
    private String detfTelefono;
    @Size(max = 100)
    @Column(name = "detf_pais")
    private String detfPais;
    @Size(max = 100)
    @Column(name = "detf_ciudad")
    private String detfCiudad;
    @Column(name = "detf_mdpnumero")
    private BigInteger detfMdpnumero;
    @Column(name = "detf_mdpdigitver")
    private Integer detfMdpdigitver;
    @Column(name = "detf_est")
    private Boolean detfEst;
    @Column(name = "indversion")
    private Integer indversion;
    @Column(name = "detf_correoe")
    private String detfCorreoe;
    @OneToMany(mappedBy = "detfId")
    private List<VntMdpxfact> vntMdpxfactList;
    @JoinColumn(name = "frn_id", referencedColumnName = "frn_id")
    @ManyToOne
    private SysFuncionario frnId;
    @JoinColumn(name = "mdp_id", referencedColumnName = "mdp_id")
    @ManyToOne
    private SysMediopago mdpId;

    public SysDetallefnr() {
    }

    public SysDetallefnr(Long detfId) {
        this.detfId = detfId;
    }

    public Long getDetfId() {
        return detfId;
    }

    public void setDetfId(Long detfId) {
        this.detfId = detfId;
    }

    public String getDetfDireccion() {
        return detfDireccion;
    }

    public void setDetfDireccion(String detfDireccion) {
        this.detfDireccion = detfDireccion;
    }

    public String getDetfDireccion1() {
        return detfDireccion1;
    }

    public void setDetfDireccion1(String detfDireccion1) {
        this.detfDireccion1 = detfDireccion1;
    }

    public String getDetfTelefono() {
        return detfTelefono;
    }

    public void setDetfTelefono(String detfTelefono) {
        this.detfTelefono = detfTelefono;
    }

    public String getDetfPais() {
        return detfPais;
    }

    public void setDetfPais(String detfPais) {
        this.detfPais = detfPais;
    }

    public String getDetfCiudad() {
        return detfCiudad;
    }

    public void setDetfCiudad(String detfCiudad) {
        this.detfCiudad = detfCiudad;
    }

    public BigInteger getDetfMdpnumero() {
        return detfMdpnumero;
    }

    public void setDetfMdpnumero(BigInteger detfMdpnumero) {
        this.detfMdpnumero = detfMdpnumero;
    }

    public Integer getDetfMdpdigitver() {
        return detfMdpdigitver;
    }

    public void setDetfMdpdigitver(Integer detfMdpdigitver) {
        this.detfMdpdigitver = detfMdpdigitver;
    }

    public Boolean getDetfEst() {
        return detfEst;
    }

    public void setDetfEst(Boolean detfEst) {
        this.detfEst = detfEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<VntMdpxfact> getVntMdpxfactList() {
        return vntMdpxfactList;
    }

    public void setVntMdpxfactList(List<VntMdpxfact> vntMdpxfactList) {
        this.vntMdpxfactList = vntMdpxfactList;
    }

    public SysFuncionario getFrnId() {
        return frnId;
    }

    public void setFrnId(SysFuncionario frnId) {
        this.frnId = frnId;
    }

    public SysMediopago getMdpId() {
        return mdpId;
    }

    public void setMdpId(SysMediopago mdpId) {
        this.mdpId = mdpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detfId != null ? detfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysDetallefnr)) {
            return false;
        }
        SysDetallefnr other = (SysDetallefnr) object;
        if ((this.detfId == null && other.detfId != null) || (this.detfId != null && !this.detfId.equals(other.detfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.SysDetallefnr[ detfId=" + detfId + " ]";
    }

    /**
     * @return the detfCorreoe
     */
    public String getDetfCorreoe() {
        return detfCorreoe;
    }

    /**
     * @param detfCorreoe the detfCorreoe to set
     */
    public void setDetfCorreoe(String detfCorreoe) {
        this.detfCorreoe = detfCorreoe;
    }
    
}
