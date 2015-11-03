/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.web.jsf.modelotablas;

import com.uniminuto.lchacon.estampate.web.base.TablaBaseFrm;
import com.unniminuto.lchacon.estampateem.modelo.SysFuncionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author fernando
 */
public class TablaSysFunc extends TablaBaseFrm {

    private SysFuncionario sf = new SysFuncionario();

    private List<TablaDetFuncionario> lstDetFuncionarios = new ArrayList<>();

    public TablaSysFunc() {
    }

    public TablaSysFunc(SysFuncionario pSf) {
        this.sf = pSf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.sf);
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
        final TablaSysFunc other = (TablaSysFunc) obj;
        return Objects.equals(this.sf, other.sf);
    }

    /**
     * @return the sf
     */
    public SysFuncionario getSf() {
        return sf;
    }

    /**
     * @param sf the sf to set
     */
    public void setSf(SysFuncionario sf) {
        this.sf = sf;
    }

    /**
     * @return the lstDetFuncionarios
     */
    public List<TablaDetFuncionario> getLstDetFuncionarios() {
        return lstDetFuncionarios;
    }

    /**
     * @param lstDetFuncionarios the lstDetFuncionarios to set
     */
    public void setLstDetFuncionarios(List<TablaDetFuncionario> lstDetFuncionarios) {
        this.lstDetFuncionarios = lstDetFuncionarios;
    }
}
