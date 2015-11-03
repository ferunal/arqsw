/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.base;

import com.uniminuto.lchacon.estampate.ejb.base.ManejoReferenciasSLBean;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

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

    @EJB
    protected ManejoReferenciasSLBean manejoReferenciasSLBean;
    //<editor-fold defaultstate="collapsed" desc="Funciones comunes">
    /**
     * Ir al servlet que de descarga de archivos
     *
     * @param pRecursoDescarga
     */
    protected void irAServletDescarga(RecursoDescarga pRecursoDescarga) {
        try {
            fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            String contextoApp = ec.getApplicationContextPath();
            HttpSession hs = (HttpSession) ec.getSession(false);            
            hs.setAttribute("rd", pRecursoDescarga);
            ec.redirect(contextoApp + "/DescargarArchivoServlet");
        } catch (IOException ex) {
            Logger.getLogger(BaseJSFBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Constante para utilizar como base en la conversión de contraseñas
     */
    private static final char[] HEXADECIMAL = {'0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Función para encriptar con el algoritmo sha2 con 512 bytes
     *
     * @param clave
     * @return
     */
    public static String hashPasswordSha512(String clave) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            String C6H5COONa = "C6H5COONa";
            StringBuilder strBClave = new StringBuilder(clave);
            strBClave.append(C6H5COONa);
            byte[] bytes = md.digest(strBClave.toString().getBytes());
            StringBuilder sb = new StringBuilder(2 * bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                int low = (bytes[i] & 0x0f);
                int high = ((bytes[i] & 0xf0) >> 4);
                sb.append(HEXADECIMAL[high]);
                sb.append(HEXADECIMAL[low]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BaseJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            return "Error";
        }

    }

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

    public abstract void navegacionLateral_ActionEvent(ActionEvent ae);

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
