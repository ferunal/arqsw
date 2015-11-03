/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.jsf;

import com.uniminuto.lchacon.estampate.ejb.base.ManejoReferenciasSLBean;
import com.uniminuto.lchacon.estampate.web.jsf.modelotablas.TablaSysFunc;
import com.uniminuto.lchacon.estampate.web.base.BaseJSFBean;
import com.uniminuto.lchacon.estampate.web.jsf.modelotablas.TablaDetFuncionario;
import com.unniminuto.lchacon.estampateem.modelo.SysFuncionario;
import com.unniminuto.lchacon.estampateem.modelo.SysMediopago;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fercris
 */
@SessionScoped
@Named
public class ComprasJSFBean extends BaseJSFBean implements Serializable {

    private TablaSysFunc tablaSysFuncSel = new TablaSysFunc();
    private TablaDetFuncionario tablaDetFuncionario = new TablaDetFuncionario();
    private Integer medioPagoSel;

    private List<TablaDetFuncionario> lstTablaDetSusFunc = new ArrayList<>();

    private String clave;
    private String repetirClave;

    @Inject
    PrincipalJSFBean pjsfb;
    
    

    private Integer tabSel;

  

    public void btnSigTab_AE(ActionEvent ae) {
        if (tabSel == 0) {
            tabSel = +1;
        }

    }

    public ComprasJSFBean() {
        tabSel = 0;
    }

    private void agregarDetalle() {
        try {
            lstTablaDetSusFunc.add((TablaDetFuncionario) tablaDetFuncionario.clone());
            tablaDetFuncionario = null;
            tablaDetFuncionario = new TablaDetFuncionario();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ComprasJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void init() {
        tabSel = 0;
    }

    @Override
    public void limpiarVariables() {

    }

    @Override
    public void navegacionLateral_ActionEvent(ActionEvent ae) {
      
      numPanel = Integer.parseInt((String) ae.getComponent().getAttributes().get("numPanel"));
    }

    @Override
    public boolean validarFormulario() {
        return true;
    }

    /**
     * @return the tablaSysFuncSel
     */
    public TablaSysFunc getTablaSysFuncSel() {
        return tablaSysFuncSel;
    }

    /**
     * @param tablaSysFuncSel the tablaSysFuncSel to set
     */
    public void setTablaSysFuncSel(TablaSysFunc tablaSysFuncSel) {
        this.tablaSysFuncSel = tablaSysFuncSel;
    }

    /**
     * @return the lstTablaDetSusFunc
     */
    public List<TablaDetFuncionario> getLstTablaDetSusFunc() {
        return lstTablaDetSusFunc;
    }

    /**
     * @param lstTablaDetSusFunc the lstTablaDetSusFunc to set
     */
    public void setLstTablaDetSusFunc(List<TablaDetFuncionario> lstTablaDetSusFunc) {
        this.lstTablaDetSusFunc = lstTablaDetSusFunc;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the repetirClave
     */
    public String getRepetirClave() {
        return repetirClave;
    }

    /**
     * @param repetirClave the repetirClave to set
     */
    public void setRepetirClave(String repetirClave) {
        this.repetirClave = repetirClave;
    }

    /**
     * @return the tabSel
     */
    public Integer getTabSel() {
        return tabSel;
    }

    /**
     * @param tabSel the tabSel to set
     */
    public void setTabSel(Integer tabSel) {
        this.tabSel = tabSel;
    }

    public TablaDetFuncionario getTablaDetFuncionario() {
        return tablaDetFuncionario;
    }

    public void setTablaDetFuncionario(TablaDetFuncionario tablaDetFuncionario) {
        this.tablaDetFuncionario = tablaDetFuncionario;
    }

    /**
     * @return the medioPagoSel
     */
    public Integer getMedioPagoSel() {
        return medioPagoSel;
    }

    /**
     * @param medioPagoSel the medioPagoSel to set
     */
    public void setMedioPagoSel(Integer medioPagoSel) {
        this.medioPagoSel = medioPagoSel;
    }

}
