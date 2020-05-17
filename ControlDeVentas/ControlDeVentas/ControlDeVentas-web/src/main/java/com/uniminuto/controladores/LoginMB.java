/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.controladores;

import co.uniminuto.entidades.UsuarioRegistrado;
import co.uniminuto.login.logica.LoginEJB;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Miguel
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    private String user;
    private String pass;

    private String userToFind;
    private String passToChanged;
    private boolean enablePass;
    UsuarioRegistrado usuarioRegistradoToChanged;

    @EJB
    LoginEJB loginEJB;

    public LoginMB() {
    }

    @PostConstruct
    public void init() {

        enablePass = true;
    }

    public String Ingresar() {

        UsuarioRegistrado usuarioRegistrado = loginEJB.existUser(user, pass);
        String url = null;
        if (usuarioRegistrado != null) {
            System.out.println("Res " + usuarioRegistrado.getUsuario() + " pass " + usuarioRegistrado.getPassword());
            if (usuarioRegistrado.getUsuario().equals(user) && usuarioRegistrado.getPassword().equals(pass)) {
                if (loginEJB.existUserLogueado(user)) {
                    System.out.println("entro cuando existe usuario logueado");
                    url = "/Menu.xhtml";
                } else {
                    boolean existuser = loginEJB.insertUserLog(usuarioRegistrado);
                    if (existuser) {
                        System.out.println("entro if");
                        url = "/Menu.xhtml";
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Informacion!", "Usuario no encontrado "));
                    }
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                        "Error!", "Error no encontrado "));
            }

            if (url != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioRegistrado);
            }
        }
        return url;
    }

    public void validaSesion() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            UsuarioRegistrado us = (UsuarioRegistrado) facesContext.getExternalContext().getSessionMap().get("usuario");
            if (us == null) {
                facesContext.getExternalContext().redirect("permisos.xhtml");
            }

        } catch (Exception e) {
            System.out.println("erro al render principal  " + e.getMessage());
        }
    }

    public void changePass() {

        if (usuarioRegistradoToChanged != null) {
            System.out.println("Res " + usuarioRegistradoToChanged.getUsuario());
            if (usuarioRegistradoToChanged.getUsuario().equals(userToFind)) {
                usuarioRegistradoToChanged.setPassword(passToChanged);
                loginEJB.updatePass(usuarioRegistradoToChanged);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Error!", "No se pudo actualizar la contraseña"));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error!", "Error no encontrado "));

        }
    }

    public void findUser() {

        usuarioRegistradoToChanged = loginEJB.existUser(userToFind);
        if (usuarioRegistradoToChanged != null) {
            enablePass = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Informacion", "Usuario no encontrado "));
        }
    }

    public void cerrarSesion() {

        String url = null;

        if (loginEJB.deleteUserLog(user)) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Info!", "Ha salido del sistema."));  
            
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error!", "Error no encontrado "));
        }


    }
    
    public void finalizaSesion() {
        
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

    public boolean isEnablePass() {
        return enablePass;
    }

    public void setEnablePass(boolean enablePass) {
        this.enablePass = enablePass;
    }

    public String getUserToFind() {
        return userToFind;
    }

    public void setUserToFind(String userToFind) {
        this.userToFind = userToFind;
    }

    public String getPassToChanged() {
        return passToChanged;
    }

    public void setPassToChanged(String passToChanged) {
        this.passToChanged = passToChanged;
    }

}
