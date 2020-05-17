/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.logica;

import co.uniminuto.entidades.Menu;
import co.uniminuto.entidades.UsuarioRegistrado;
import co.uniminuto.entidades.Vendedor;
import co.uniminuto.entidades.Zona;
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
    
    
    public List<Menu> getMenu(){
        
        List<Menu> list = new ArrayList<>();
        try{
            Query query = em.createNamedQuery("Menu.findAll");
            list = query.getResultList();
        }catch(Exception e){
            System.err.println("Error al consultar menu " + e.getMessage());
        }
        return  list;
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
     
    public List<Zona> getZonas(){
         List<Zona> list = new ArrayList<Zona>();
        try {        
           Query query = em.createNamedQuery("Zona.findAll");
           list = query.getResultList();
        } catch (Exception e) {
            System.err.println("error al consultar Zonas " + e.getMessage());
        }
        return list;
    } 
    
    
     public List<Vendedor> getVendedores(){
         List<Vendedor> list = new ArrayList<>();
        try {        
           Query query = em.createNamedQuery("Vendedor.findAll");
           list = query.getResultList();
        } catch (Exception e) {
             System.err.println("error al consultar Vendedores " + e.getMessage());
        }
        return list;
    } 
    
}
