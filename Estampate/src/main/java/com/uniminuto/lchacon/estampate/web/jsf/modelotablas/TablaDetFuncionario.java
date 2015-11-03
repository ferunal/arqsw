/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.jsf.modelotablas;

import com.uniminuto.lchacon.estampate.web.base.TablaBaseFrm;
import com.unniminuto.lchacon.estampateem.modelo.SysDetallefnr;
import java.util.Objects;

/**
 *
 * @author fercris
 */
public class TablaDetFuncionario extends TablaBaseFrm implements Cloneable{
  private  SysDetallefnr sysDetallefnr = new SysDetallefnr();

    public SysDetallefnr getSysDetallefnr() {
        return sysDetallefnr;
    }

    public void setSysDetallefnr(SysDetallefnr sysDetallefnr) {
        this.sysDetallefnr = sysDetallefnr;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.sysDetallefnr);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TablaDetFuncionario other = (TablaDetFuncionario) obj;
        return Objects.equals(this.sysDetallefnr, other.sysDetallefnr);
    }
    
    
}
