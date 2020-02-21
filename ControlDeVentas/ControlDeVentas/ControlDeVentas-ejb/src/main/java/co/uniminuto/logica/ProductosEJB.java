/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.logica;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Miguel
 */

@Stateless
public class ProductosEJB extends AbstractFacade{
    
    @PersistenceContext(unitName = "Pedidos_jdni")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
      return em;
    }
    
    
    
    
}
