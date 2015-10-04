/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author fercris
 */
public abstract class BaseJSFBean {

    //<editor-fold defaultstate="collapsed" desc="Variables comunes">

    protected SelectItem itemSeleccioneStr = new SelectItem("-1", "Seleccione>>");
    protected SelectItem itemSeleccioneInt = new SelectItem(-1, "Seleccione>>");
    protected SelectItem itemSeleccioneLng = new SelectItem(-1l, "Seleccione>>");
    protected FacesContext fc = FacesContext.getCurrentInstance();
    protected ELContext elc;
    protected Integer numPanel = 1;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Funciones comunes">
    protected String encriptar(String cleartext, String key) throws Exception {
        try {
            return crypt(cleartext, key, Cipher.ENCRYPT_MODE);
        } catch (Exception ex) {
            throw new Exception("Imposible encriptar los datos.");
        }
    }

    protected String desEncriptar(String ciphertext, String key) throws Exception {
        try {
            return crypt(ciphertext, key, Cipher.DECRYPT_MODE);
        } catch (Exception ex) {
            throw new Exception("Imposible desencriptar los datos.");
        }
    }

    protected String crypt(String input, String key, int mode) throws Exception {
        // Install SunJCE provider
        Provider sunJce = new com.sun.crypto.provider.SunJCE();
        Security.addProvider(sunJce);

        KeyGenerator kgen = KeyGenerator.getInstance("Blowfish");
        kgen.init(448);
        SecretKey skey = kgen.generateKey();

        byte[] raw = key.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");

        Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
        cipher.init(mode, skeySpec);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        CipherOutputStream cos;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes())) {
            cos = new CipherOutputStream(bos, cipher);
            int length;
            byte[] buffer = new byte[8192];
            while ((length = bis.read(buffer)) != -1) {
                cos.write(buffer, 0, length);
            }
        }
        cos.close();

        return bos.toString();
    }

    protected boolean esNumero(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() > 1) {
                i++;
            } else {
                return false;
            }
        }
        for (; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones abstractas">
    public abstract void init();

    public abstract void limpiarVariables();

    public abstract void navegacionLateral_ActionEvent(Integer numPanel);

    public abstract boolean validarFormulario();

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Manejo listas">

    /**
     * Eliminar los elementos seleccionados de una tabla
     *
     * @param lst
     * @return Lista de elementos eliminados para hacer las operaciones
     * correspondientes
     */
    protected List retirarElemTabla(List<? extends TablaBaseFrm> lst) {
        List lstRerirar = new ArrayList();
        lst.stream().filter(e -> e.isSeleccionado()).forEach(lstRerirar::add);
        lst.removeAll(lstRerirar);
        return lstRerirar;
    }

    /**
     * Resaltar la fila seleccionada de una tabla, la lista debe ser de objetos
     * que hereden de la clase TablaBaseGrid
     *
     * @param lst
     * @param objSel
     */
    public void resaltarFilaTabla(List<? extends TablaBaseFrm> lst, Object objSel) {
        lst.stream().forEach(p -> {
            if (p.equals(objSel)) {
                p.setSeleccionado(true);
                p.setClaseSel("seleccione");
            } else {
                p.setSeleccionado(false);
                p.setClaseSel("");
            }
        });

    }

    /**
     * Cambiar el estado del campo seleccionado de una lista tipo tabla
     *
     * @param lst Lista
     * @param sel estado del campo
     */
    protected void selTodoLst(List<? extends TablaBaseFrm> lst, boolean sel) {
        lst.stream().forEach(p -> p.setSeleccionado(sel));

    }

    //</editor-fold>

    /**
     * @return the itemSeleccioneStr
     */
    public SelectItem getItemSeleccioneStr() {
        return itemSeleccioneStr;
    }

    /**
     * @param itemSeleccioneStr the itemSeleccioneStr to set
     */
    public void setItemSeleccioneStr(SelectItem itemSeleccioneStr) {
        this.itemSeleccioneStr = itemSeleccioneStr;
    }

    /**
     * @return the itemSeleccioneInt
     */
    public SelectItem getItemSeleccioneInt() {
        return itemSeleccioneInt;
    }

    /**
     * @param itemSeleccioneInt the itemSeleccioneInt to set
     */
    public void setItemSeleccioneInt(SelectItem itemSeleccioneInt) {
        this.itemSeleccioneInt = itemSeleccioneInt;
    }

    /**
     * @return the itemSeleccioneLng
     */
    public SelectItem getItemSeleccioneLng() {
        return itemSeleccioneLng;
    }

    /**
     * @param itemSeleccioneLng the itemSeleccioneLng to set
     */
    public void setItemSeleccioneLng(SelectItem itemSeleccioneLng) {
        this.itemSeleccioneLng = itemSeleccioneLng;
    }

    /**
     * @return the numPanel
     */
    public Integer getNumPanel() {
        return numPanel;
    }

    /**
     * @param numPanel the numPanel to set
     */
    public void setNumPanel(Integer numPanel) {
        this.numPanel = numPanel;
    }
}
