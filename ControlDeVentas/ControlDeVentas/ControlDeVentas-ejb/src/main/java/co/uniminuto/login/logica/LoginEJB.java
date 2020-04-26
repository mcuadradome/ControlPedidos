/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.login.logica;

import co.uniminuto.entidades.UsuarioRegistrado;
import com.uniminuto.logica.VO.ProductosVO;
import com.uniminuto.login.vo.UsuarioVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Miguel
 */
@Stateless
public class LoginEJB extends AbstractFacade{

    private UsuarioRegistrado usuarioLogueado;
    
    @PersistenceContext(unitName = "EntidadesPU")
    private EntityManager em;

    public LoginEJB() {
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public LoginEJB(Class EnClass){
        super(EnClass);
    }
   
    @PostConstruct
    public void init(){
        usuarioLogueado = new UsuarioRegistrado();
    }
    
    public UsuarioRegistrado existUser(UsuarioVO usuarioVO){
        
        try {
            System.out.println("User " +usuarioVO.getUsuario() + " : " + usuarioVO.getPassword());
            //String sql ="select * from USUARIO_REGISTRADO  where usuario= :usuario and password= :password";
            
            usuarioLogueado = (UsuarioRegistrado) em.createNamedQuery("UsuarioRegistrado.findByUsuario").setParameter("usuario", usuarioVO.getUsuario()).getSingleResult();
           // query.setParameter("usuario", usuarioVO.getUsuario());
           // query.setParameter("password", usuarioVO.getPassword());
            
           return usuarioLogueado;
            
        } catch (Exception e) {
            System.err.println("Error al consultar usuario " + usuarioVO.getUsuario() + e.getMessage());
            return null;
        }
    
    }
    
   

}