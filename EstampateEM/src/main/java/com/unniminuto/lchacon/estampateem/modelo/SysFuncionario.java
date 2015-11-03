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
@Table(name = "sys_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysFuncionario.findAll", query = "SELECT s FROM SysFuncionario s ORDER BY s.frnNombre, s.frnApellido"),
    @NamedQuery(name = "SysFuncionario.findByFrnId", query = "SELECT s FROM SysFuncionario s WHERE s.frnId = :frnId"),
    @NamedQuery(name = "SysFuncionario.findByFrnNombre", query = "SELECT s FROM SysFuncionario s WHERE s.frnNombre = :frnNombre"),
    @NamedQuery(name = "SysFuncionario.findByFrnApellido", query = "SELECT s FROM SysFuncionario s WHERE s.frnApellido = :frnApellido"),
    @NamedQuery(name = "SysFuncionario.findByFrnUsuario", query = "SELECT s FROM SysFuncionario s WHERE s.frnUsuario = :frnUsuario"),
    @NamedQuery(name = "SysFuncionario.findByFrnClave", query = "SELECT s FROM SysFuncionario s WHERE s.frnClave = :frnClave"),
    @NamedQuery(name = "SysFuncionario.findByFrnEstado", query = "SELECT s FROM SysFuncionario s WHERE s.frnEstado = :frnEstado"),
    @NamedQuery(name = "SysFuncionario.findByIndversion", query = "SELECT s FROM SysFuncionario s WHERE s.indversion = :indversion"),
    @NamedQuery(name = "SysFuncionario.validarUsr", query = "SELECT u FROM SysFuncionario u WHERE u.frnUsuario = :frnUsuario AND u.frnClave = :frnClave ")
})
public class SysFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "frn_id")
    private String frnId;
    @Size(max = 250)
    @Column(name = "frn_nombre")
    private String frnNombre;
    @Size(max = 250)
    @Column(name = "frn_apellido")
    private String frnApellido;
    @Size(max = 100)
    @Column(name = "frn_usuario")
    private String frnUsuario;
    @Size(max = 2000)
    @Column(name = "frn_clave")
    private String frnClave;
    @Column(name = "frn_estado")
    private Boolean frnEstado;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "frnId")
    private List<SysSubmodxfrn> sysSubmodxfrnList;
    @OneToMany(mappedBy = "frnId")
    private List<SysDetallefnr> sysDetallefnrList;
    @OneToMany(mappedBy = "frnId")
    private List<SysRolxfrn> sysRolxfrnList;

    public SysFuncionario() {
    }

    public SysFuncionario(String frnId) {
        this.frnId = frnId;
    }

    public String getFrnId() {
        return frnId;
    }

    public void setFrnId(String frnId) {
        this.frnId = frnId;
    }

    public String getFrnNombre() {
        return frnNombre;
    }

    public void setFrnNombre(String frnNombre) {
        this.frnNombre = frnNombre;
    }

    public String getFrnApellido() {
        return frnApellido;
    }

    public void setFrnApellido(String frnApellido) {
        this.frnApellido = frnApellido;
    }

    public String getFrnUsuario() {
        return frnUsuario;
    }

    public void setFrnUsuario(String frnUsuario) {
        this.frnUsuario = frnUsuario;
    }

    public String getFrnClave() {
        return frnClave;
    }

    public void setFrnClave(String frnClave) {
        this.frnClave = frnClave;
    }

    public Boolean getFrnEstado() {
        return frnEstado;
    }

    public void setFrnEstado(Boolean frnEstado) {
        this.frnEstado = frnEstado;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<SysSubmodxfrn> getSysSubmodxfrnList() {
        return sysSubmodxfrnList;
    }

    public void setSysSubmodxfrnList(List<SysSubmodxfrn> sysSubmodxfrnList) {
        this.sysSubmodxfrnList = sysSubmodxfrnList;
    }

    @XmlTransient
    public List<SysDetallefnr> getSysDetallefnrList() {
        return sysDetallefnrList;
    }

    public void setSysDetallefnrList(List<SysDetallefnr> sysDetallefnrList) {
        this.sysDetallefnrList = sysDetallefnrList;
    }

    @XmlTransient
    public List<SysRolxfrn> getSysRolxfrnList() {
        return sysRolxfrnList;
    }

    public void setSysRolxfrnList(List<SysRolxfrn> sysRolxfrnList) {
        this.sysRolxfrnList = sysRolxfrnList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frnId != null ? frnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysFuncionario)) {
            return false;
        }
        SysFuncionario other = (SysFuncionario) object;
        return !((this.frnId == null && other.frnId != null) || (this.frnId != null && !this.frnId.equals(other.frnId)));
    }

    @Override
    public String toString() {
        return "com.unniminuto.lchacon.estampateem.modelo.SysFuncionario[ frnId=" + frnId + " ]";
    }

}
