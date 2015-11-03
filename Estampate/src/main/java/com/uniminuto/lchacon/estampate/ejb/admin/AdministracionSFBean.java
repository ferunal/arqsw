/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.ejb.admin;

import com.uniminuto.lchacon.estampate.ejb.base.BaseEJB;
import com.unniminuto.lchacon.estampateem.modelo.SysFuncionario;
import com.unniminuto.lchacon.estampateem.modelo.SysMediopago;
import com.unniminuto.lchacon.estampateem.modelo.SysMenuprin;
import com.unniminuto.lchacon.estampateem.modelo.SysModulos;
import com.unniminuto.lchacon.estampateem.modelo.SysSubmodulo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.Query;

/**
 *
 * @author fercris
 */
@Stateful
@LocalBean
public class AdministracionSFBean extends BaseEJB {
    //<editor-fold defaultstate="collapsed" desc="Admin usuario">
    
   
    
    public void agregarUsuario(SysFuncionario pSysFunc){
     pSysFunc = emEst.merge(pSysFunc);
             
    }
    
    public List<SysFuncionario> getLstSysFuncionarios(){
      return emEst.createNamedQuery("SysFuncionario.findAll").getResultList();
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Menu navegacion">
    public List<SysMenuprin> getLstMenuprins() {

        Query q = emEst.createNamedQuery("SysMenuprin.findAll");
        return q.getResultList();
    }

    public List<SysMenuprin> getLstMenuprinsxFrn(String pfrnId) {

        Query q = emEst.createNamedQuery("SysMenuprin.menxFrn");
        q.setParameter("frnId", pfrnId);
        q.setParameter("menEst", Boolean.TRUE);
        return q.getResultList();

    }

    public List<SysModulos> getLstModulosxMenu(Integer pmenId) {

        Query q = emEst.createNamedQuery("SysModulos.modulosXMenu");
        q.setParameter("menId", pmenId);
        q.setParameter("procEstado", Boolean.TRUE);
        return q.getResultList();
    }

    public List<SysSubmodulo> getLstSubmodproc() {
        Query q = emEst.createNamedQuery("SysSubmodulo.findAll");
        return q.getResultList();
    }

    public List<SysSubmodulo> getLstSubmodprocxFrn(String pfrnId) {

        Query q = emEst.createNamedQuery("SysSubmodulo.submodxFrn");
        q.setParameter("frnId", pfrnId);
        return q.getResultList();
    }

    public List<SysSubmodulo> getLstSubmodprocxMod(Integer pprocId) {

        Query q = emEst.createNamedQuery("SysSubmodproc.submodxModulos");
        q.setParameter("procId", pprocId);
        return q.getResultList();
    }

    public List<SysSubmodulo> getLstSubmodprocxModXFrn(String pFrnId, Integer pProcId) {
        Query q = emEst.createNamedQuery("SysSubmodulo.submodxModulosXFuncionario");
        q.setParameter("procId", pProcId);
        q.setParameter("frnId", pFrnId);
        return q.getResultList();
    }
//</editor-fold>

    
}
