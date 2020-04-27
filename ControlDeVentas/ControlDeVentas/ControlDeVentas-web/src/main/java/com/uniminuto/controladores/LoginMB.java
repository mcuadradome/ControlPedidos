/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.controladores;

import co.uniminuto.entidades.UsuarioRegistrado;
import co.uniminuto.login.logica.LoginEJB;
import com.uniminuto.logica.VO.ProductosVO;
import com.uniminuto.login.vo.UsuarioVO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Miguel
 */
@Named(value = "loginMB")
@ViewScoped
public class LoginMB implements Serializable {

    private String user;
    private String pass;

    
    @EJB
    LoginEJB loginEJB;
    
    public LoginMB() {
    }
    
    @PostConstruct
    public void  init(){
      
    }
    
    
    public String Ingresar(){
        UsuarioVO usuarioVO = new UsuarioVO();
        
        usuarioVO.setUsuario(user);
        usuarioVO.setPassword(pass);
        
        UsuarioRegistrado usuarioRegistrado = loginEJB.existUser(usuarioVO);
      
        if(usuarioRegistrado != null){
            System.out.println("Res " + usuarioRegistrado.getUsuario());
            if(usuarioRegistrado.getUsuario().equals(user) && usuarioRegistrado.getPassword().equals(pass)){
               return "/Home.xhtml"; 
            }else{
                return "/Error.xhtml";
            }
        }else{
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, 
                   "Error!", "Error no encontrado ")); 
           return "/Home.xhtm";
        }
      
    }
    
    public String cerrarSesion(){
        return "/index.xhtml";
    }


    // Getter and Setters
    
   
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public LoginEJB getLoginEJB() {
        return loginEJB;
    }

    public void setLoginEJB(LoginEJB loginEJB) {
        this.loginEJB = loginEJB;
    }
    
    
    
    
}
