/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.base;

import com.unniminuto.lchacon.estampateem.modelo.SysMediopago;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;


/**
 *
 * @author fercris
 */
@ApplicationScoped
@Named
public class AplicacionJSFBean extends BaseJSFBean {

    public AplicacionJSFBean() {
        Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.INFO, null, "Contexto inicializado....");
        Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.INFO, "Creando carpeta de almacenamiento de imagenes si no existe....");
        Path carpetaEstampate = Paths.get(System.getProperty("user.home"), "estampate");
        if (!Files.exists(carpetaEstampate)) {
            try {
                Files.createDirectory(carpetaEstampate);
                Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.INFO, "Carpeta estámpate creada....");
            } catch (IOException e) {
                Logger.getLogger(AplicacionJSFBean.class.getName()).log(Level.SEVERE, "Error creando la carpeta inicial..");
            }
        }
    }

    Function<SysMediopago, SelectItem> fnTransfMedioPago = e -> new SelectItem(e.getMdpId(), e.getMdpNombre());
    private List<SysMediopago> lstMediosPago = new ArrayList<>();

    private void cargarItemsMedioPago() {
        lstItemsMedioPago.add(itemSeleccioneInt);
        lstItemsMedioPago.addAll(manejoReferenciasSLBean.getLstMediopago().
                stream().map(fnTransfMedioPago).
                collect(Collectors.toList()));
    }
    private List<SelectItem> lstItemsMedioPago;

    @PostConstruct
    @Override
    public void init() {
        lstItemsMedioPago = new ArrayList<>();
        cargarItemsMedioPago();
    }

    /**
     * @return the lstMediosPago
     */
    public List<SysMediopago> getLstMediosPago() {
        return lstMediosPago;
    }

    /**
     * @param lstMediosPago the lstMediosPago to set
     */
    public void setLstMediosPago(List<SysMediopago> lstMediosPago) {
        this.lstMediosPago = lstMediosPago;
    }

    @Override
    public void limpiarVariables() {

    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {

    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

    /**
     * @return the lstItemsMedioPago
     */
    public List<SelectItem> getLstItemsMedioPago() {
        return lstItemsMedioPago;
    }

    /**
     * @param lstItemsMedioPago the lstItemsMedioPago to set
     */
    public void setLstItemsMedioPago(List<SelectItem> lstItemsMedioPago) {
        this.lstItemsMedioPago = lstItemsMedioPago;
    }

}
