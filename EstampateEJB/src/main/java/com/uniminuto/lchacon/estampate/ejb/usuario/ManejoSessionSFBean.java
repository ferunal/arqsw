/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.ejb.usuario;

import com.uniminuto.lchacon.estampate.ejb.base.BaseEJB;
import com.unniminuto.lchacon.estampateem.modelo.SysFuncionario;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author fercris
 */
@Stateful
@LocalBean
public class ManejoSessionSFBean extends BaseEJB {

   private SysFuncionario frnlogeado = new SysFuncionario();

    public void validaringreso(SysFuncionario pSysFuncionario) {

        Query q = emEst.createNamedQuery("SysFuncionario.validarUsr");
        q.setParameter("frnUsuario", pSysFuncionario.getFrnUsuario());
        q.setParameter("frnClave", pSysFuncionario.getFrnClave());
        try {

            frnlogeado = (SysFuncionario) q.getSingleResult();

        } catch (NoResultException | NonUniqueResultException e) {
        }
    }
    
      public SysFuncionario getFrnlogeado() {
        return frnlogeado;
    }

}
