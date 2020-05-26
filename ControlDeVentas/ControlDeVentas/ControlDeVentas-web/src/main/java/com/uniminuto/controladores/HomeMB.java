/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.controladores;

import co.uniminuto.entidades.Productos;
import co.uniminuto.logica.GeneralEJB;
import com.uniminuto.logica.VO.InventarioVO;
import com.uniminuto.logica.VO.ProductosVO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Miguel
 */
@Named(value = "homeMB")
@ViewScoped
public class HomeMB implements Serializable {

    /**
     * Creates a new instance of HomeMB
     */
    
    private String codigo;  
    private String nombreProducto;   
    private int precio;
    private int IVA;
    private int embalaje;
    private List<ProductosVO> list;
    
    @EJB
    GeneralEJB generalEJB;
    
    public HomeMB() {
    }
    
    
    @PostConstruct
    public void  init(){
        list = generalEJB.getProductos();
    }
    
    public void onCellEdit(CellEditEvent event){
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        if(newValue != null && !newValue.equals(oldValue)) {
   
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
  
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int IVA) {
        this.IVA = IVA;
    }

    public int getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(int embalaje) {
        this.embalaje = embalaje;
    }
    
    
    
    
    public List<ProductosVO> getList() {
        return list;
    }

    public void setList(List<ProductosVO> list) {
        this.list = list;
    }
    
}
