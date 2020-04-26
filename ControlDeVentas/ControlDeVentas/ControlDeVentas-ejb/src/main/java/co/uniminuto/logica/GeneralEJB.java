/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.logica;

import co.uniminuto.entidades.UsuarioRegistrado;
import com.uniminuto.logica.VO.ProductosVO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import co.uniminuto.logica.AbstractFacade;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */
@Stateless
public class GeneralEJB  extends AbstractFacade{
    
    
    @PersistenceContext(unitName = "EntidadesPU")
    private EntityManager em;
    
     @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
     @PostConstruct
    public void init(){
        
    }
    
    
     public List<ProductosVO> getProductos(){
        
        List<ProductosVO> list = new ArrayList<>();
        try{
            Query query = em.createNamedQuery("Productos.findAll");
            list = query.getResultList();
        }catch(Exception e){
            
        }
        return  list;
    }
    
}
