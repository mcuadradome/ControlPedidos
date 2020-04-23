/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Miguel
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    /**
     * Creates a new instance of LoginMB
     */
    public LoginMB() {
    }
    
}
