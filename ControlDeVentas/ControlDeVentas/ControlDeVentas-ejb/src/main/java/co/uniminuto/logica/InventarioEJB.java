/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.logica;

import co.uniminuto.entidades.Productos;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Miguel
 */
@Stateless
@LocalBean
public class InventarioEJB  extends AbstractFacade{

    
    
    
    @PersistenceContext(unitName = "EntidadesPU")
    private EntityManager em;
    
     @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     @PostConstruct
    public void init(){
        
    }
    
   
    
}
