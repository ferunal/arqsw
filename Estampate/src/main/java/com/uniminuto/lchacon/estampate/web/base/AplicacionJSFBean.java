/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author fercris
 */
@ApplicationScoped
@Named
public class AplicacionJSFBean {

    public AplicacionJSFBean() {
Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.INFO, null, "Contexto inicializado....");
        Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.INFO,  "Creando carpete de almacenamiento de imagenes si no existe....");
        Path carpetaEstampate = Paths.get(System.getProperty("user.home"), "estampate");
        if (!Files.exists(carpetaEstampate)) {
            try {
                Files.createDirectory(carpetaEstampate);
                Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.INFO,  "Carpeta estámpate creada....");
            } catch (IOException e) {
                Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.SEVERE,  "Error creando la carpeta inicial..");
            }
        }
    }

    @PostConstruct
    public void init() {
        
    }

}
