/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uniminuto.lchacon.estampate.web.base;

/**
 *
 * @author fercris
 */
public class RecursoDescarga {
    private byte[] byteRecurso ;
    private String tipoMime;
    private String nombre;

    public RecursoDescarga() {
    }

    public RecursoDescarga(byte[] byteRecurso, String tipoMime, String nombre) {
        this.byteRecurso = byteRecurso;
        this.tipoMime = tipoMime;
        this.nombre = nombre;
    }

    
    
    /**
     * @return the byteRecurso
     */
    public byte[] getByteRecurso() {
        return byteRecurso;
    }

    /**
     * @param byteRecurso the byteRecurso to set
     */
    public void setByteRecurso(byte[] byteRecurso) {
        this.byteRecurso = byteRecurso;
    }

    /**
     * @return the tipoMime
     */
    public String getTipoMime() {
        return tipoMime;
    }

    /**
     * @param tipoMime the tipoMime to set
     */
    public void setTipoMime(String tipoMime) {
        this.tipoMime = tipoMime;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
