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

    private String userToFind;
    private String passToChanged;
    private boolean enablePass;

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

        if (usuarioRegistrado != null) {
            System.out.println("Res " + usuarioRegistrado.getUsuario() + " pass " + usuarioRegistrado.getPassword());
            if (usuarioRegistrado.getUsuario().equals(user) && usuarioRegistrado.getPassword().equals(pass)) {
                if (loginEJB.existUserLogueado(user)) {
                     System.out.println("entro if");
                        return "Home.xhtml";
                } else {
                    boolean existuser = loginEJB.insertUserLog(usuarioRegistrado);
                    if (existuser) {
                        System.out.println("entro if");
                        return "Home.xhtml";
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Informacion!", "Usuario no encontrado "));
                        return "index.xhtml";
                    }
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                        "Error!", "Error no encontrado "));
                return "index.xhtml";
            }
        }
        return "index.xhtml";
    }

    public void changePass() {

        UsuarioRegistrado usuarioRegistrado = loginEJB.existUser(user);

        if (usuarioRegistrado != null) {
            System.out.println("Res " + usuarioRegistrado.getUsuario());
            if (usuarioRegistrado.getUsuario().equals(user)) {
                loginEJB.updatePass(usuarioRegistrado);
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

        UsuarioRegistrado usuarioRegistrado = loginEJB.existUser(user);
        if (usuarioRegistrado != null) {
            enablePass = true;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Informacion", "Usuario no encontrado "));
        }
    }

    public String cerrarSesion() {

        if (loginEJB.deleteUserLog(user)) {
            return "/index.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error!", "Error no encontrado "));
            return "";
        }

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
