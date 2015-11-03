/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.ejb.base;

import com.unniminuto.lchacon.estampateem.modelo.RefColor;
import com.unniminuto.lchacon.estampateem.modelo.RefEstilo;
import com.unniminuto.lchacon.estampateem.modelo.RefMaterial;
import com.unniminuto.lchacon.estampateem.modelo.RefTalla;
import com.unniminuto.lchacon.estampateem.modelo.SysMediopago;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author fercris
 */
@Stateless
public class ManejoReferenciasSLBean extends BaseEJB {

    
    
    
    public List<SysMediopago> getLstMediopago() {
        return emEst.createNamedQuery("SysMediopago.findAll").getResultList();
    }

    public List<RefColor> getLstColor() {
        return emEst.createNamedQuery("RefColor.findAll").getResultList();
    }

    public List<RefTalla> getLstRefTalla() {
        return emEst.createNamedQuery("RefTalla.findAll").getResultList();
    }

    public List<RefEstilo> getLstEstilo() {
        return emEst.createNamedQuery("RefEstilo.findAll").getResultList();
    }

    public List<RefMaterial> getLstMaterial() {
        return emEst.createNamedQuery("RefMaterial.findAll").getResultList();
    }
}
