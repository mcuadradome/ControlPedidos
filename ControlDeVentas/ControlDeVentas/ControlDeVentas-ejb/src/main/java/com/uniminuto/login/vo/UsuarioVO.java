/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.login.vo;

/**
 *
 * @author Miguel
 */
public class UsuarioVO {
    
    private int id;
    private int id_usuario_fk;
    private String usuario;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(int id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
