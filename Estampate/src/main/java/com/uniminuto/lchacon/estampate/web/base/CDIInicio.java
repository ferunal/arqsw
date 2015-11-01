/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.base;

import com.uniminuto.lchacon.estampate.ejb.usuario.ManejoSessionSFBean;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author fercris
 */
public class CDIInicio {
    ManejoSessionSFBean manejoSessionSFBean = lookupManejoSessionSFBeanBean();

    public void postConstruct(@Observes @Initialized(ApplicationScoped.class) Object o) {
      
    }

    private ManejoSessionSFBean lookupManejoSessionSFBeanBean() {
        try {
            Context c = new InitialContext();
            return (ManejoSessionSFBean) c.lookup("java:global/com.uniminuto.lchacon_Estampate_war_1/ManejoSessionSFBean!com.uniminuto.lchacon.estampate.ejb.usuario.ManejoSessionSFBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
