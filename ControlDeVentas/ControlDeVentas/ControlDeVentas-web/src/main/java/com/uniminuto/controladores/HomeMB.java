/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.controladores;

import co.uniminuto.logica.GeneralEJB;
import com.uniminuto.logica.VO.ProductosVO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Miguel
 */
@Named(value = "homeMB")
@SessionScoped
public class HomeMB implements Serializable {

    /**
     * Creates a new instance of HomeMB
     */
    
    private List<ProductosVO> list;
    
    @EJB
    GeneralEJB generalEJB;
    
    public HomeMB() {
    }
    
    
    @PostConstruct
    public void  init(){
        list = generalEJB.getProductos();
    }
    
    
    
    public List<ProductosVO> getList() {
        return list;
    }

    public void setList(List<ProductosVO> list) {
        this.list = list;
    }
    
}
