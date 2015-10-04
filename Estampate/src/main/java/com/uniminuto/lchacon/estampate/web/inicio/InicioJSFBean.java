/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.inicio;

import com.uniminuto.lchacon.estampate.web.base.AplicacionJSFBean;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fercris
 */
@SessionScoped
@Named
public class InicioJSFBean implements Serializable{

    private String usuario;
    private String clave;

    @Inject
    AplicacionJSFBean ajsfb;
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void validarUsuario() {
        System.out.println(usuario);
        System.out.println(clave);
    }
}
