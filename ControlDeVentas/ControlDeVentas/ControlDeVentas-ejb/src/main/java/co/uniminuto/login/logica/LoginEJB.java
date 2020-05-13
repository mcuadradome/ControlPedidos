/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.login.logica;

import co.uniminuto.entidades.UsuarioLogueado;
import co.uniminuto.entidades.UsuarioRegistrado;
import com.uniminuto.logica.VO.ProductosVO;
import com.uniminuto.login.vo.UsuarioVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Miguel
 */
@Singleton
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
    
    public UsuarioRegistrado existUser(String usuario){
        
        try {
            System.out.println("User " + usuario);
              
            usuarioLogueado = (UsuarioRegistrado) em.createNamedQuery("UsuarioRegistrado.findByUsuario").setParameter("usuario", usuario).getSingleResult();
       
           return usuarioLogueado;
            
        } catch (Exception e) {
            System.err.println("Error al consultar usuario " + usuario + e.getMessage());
            return null;
        }
    
    }
    
    public UsuarioRegistrado existUser(String usuario, String pass){
        
        try {
            UsuarioRegistrado usuarioRegistrado = new UsuarioRegistrado();
            System.out.println("User " + usuario + " pass " + pass);
           // String sql ="select * from USUARIO_REGISTRADO  where usuario= :usuario and password= :password";
            usuarioRegistrado = (UsuarioRegistrado) em.createNamedQuery("UsuarioRegistrado.findByUsuario")
                    .setParameter("usuario", usuario).getSingleResult();
       
           // Query query = em.createNativeQuery(sql);
            //query.setParameter("usuario", usuario);
            //query.setParameter("password", pass);
      
           return usuarioRegistrado;
            
        } catch (Exception e) {
            System.err.println("Error al consultar usuario registrado: " + usuario + e.getMessage());
            return null;
        }
    
    }
    
    
     public boolean existUserLogueado(String usuario){
        
        try {
            UsuarioLogueado usuarioRegistrado = new UsuarioLogueado();
           
            
           // String sql ="select * from USUARIO_REGISTRADO  where usuario= :usuario and password= :password";
            usuarioRegistrado = (UsuarioLogueado) em.createNamedQuery("UsuarioLogueado.findByUsuario")
                    .setParameter("usuario", usuario).getSingleResult();

            if(usuarioRegistrado != null){
                return true;
            }
                    
        } catch (Exception e) {
            System.err.println("Error al consultar usuario registrado: " + usuario + e.getMessage());
            return false;
        }
        return false;
    }
    
    public boolean insertUserLog(UsuarioRegistrado registrado){
        try {
            if(registrado != null){
                UsuarioLogueado usuarioLogueado = new UsuarioLogueado();
                
                String sql= "INSERT INTO USUARIO_LOGUEADO VALUES (?,?);";
                System.out.println("user iner " + registrado.getIdUsuarioFk() + registrado.getUsuario() + registrado.getPassword());
                Query query = em.createNativeQuery(sql);
                
                query.setParameter(1,  registrado.getIdUsuarioFk());
                query.setParameter(2,  registrado.getUsuario());
                
                query.executeUpdate();
                        
                return true;
            }                         
        } catch (Exception e) {
            System.out.println("Error al insertar usuario " + e.getMessage());
            return false;
        }
        return false;

    }
    
      public boolean updatePass(UsuarioRegistrado registrado){
        try {
            if(registrado != null){              
                em.persist(registrado);               
                return true;
            }                         
        } catch (Exception e) {
            return false;
        }
        return false;

    }
      
      public boolean deleteUserLog(String user){
          
          try {
              
            System.out.println("User logueado a elimar " + user);
              
            usuarioLogueado = (UsuarioRegistrado) em.createNamedQuery("UsuarioLogueado.findByUsuario").setParameter("usuario", user).getSingleResult();
                
            em.remove(usuarioLogueado);
            return true;
          
          } catch (Exception e) {
              System.err.println("Error al eliminar usuario registrado");
          }
         return false;
      }

}