/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.lchacon.estampate.ejb.base;

import javax.ejb.Remove;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fercris
 */


public abstract class BaseEJB {
    
    @PersistenceContext(unitName = "estampatePU")
    protected EntityManager emEst;
    
     @Remove
    public void remove() {
    }
    
}
