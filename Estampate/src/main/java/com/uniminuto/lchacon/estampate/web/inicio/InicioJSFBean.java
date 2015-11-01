/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.inicio;

import com.uniminuto.lchacon.estampate.ejb.usuario.ManejoSessionSFBean;
import com.uniminuto.lchacon.estampate.web.base.AplicacionJSFBean;
import com.uniminuto.lchacon.estampate.web.base.BaseJSFBean;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.faces.event.ActionListener;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author fercris
 */
@SessionScoped
@Named
public class InicioJSFBean extends BaseJSFBean implements Serializable {

    ManejoSessionSFBean manejoSessionSFBean = lookupManejoSessionSFBeanBean();

    private ManejoSessionSFBean lookupManejoSessionSFBeanBean() {
        try {
            Context c = new InitialContext();
            return (ManejoSessionSFBean) c.lookup("java:global/Estampate/ManejoSessionSFBean!com.uniminuto.lchacon.estampate.ejb.usuario.ManejoSessionSFBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

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

    public void validarUsuario(ActionListener ae) {
        System.out.println(usuario);
        System.out.println(clave);
    }

    @Override
    public void init() {

    }

    @Override
    public void limpiarVariables() {

    }

    @Override
    public void navegacionLateral_ActionEvent(Integer numPanel) {

    }

    @Override
    public boolean validarFormulario() {
        return true;
    }
}
