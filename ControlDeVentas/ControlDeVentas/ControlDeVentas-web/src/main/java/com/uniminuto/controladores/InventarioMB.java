/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.controladores;

import co.uniminuto.entidades.CargueInventario;
import co.uniminuto.entidades.Productos;
import co.uniminuto.entidades.Zona;
import co.uniminuto.logica.GeneralEJB;
import co.uniminuto.logica.InventarioEJB;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Miguel
 */
@Named(value = "InventarioMB")
@ViewScoped
public class InventarioMB implements Serializable {

    private int cantidad;
    private Productos productos;
    private CargueInventario cargueInventario;
    private List<Zona> zona = new ArrayList<>();  
    private String fecha;

    @EJB
    GeneralEJB generalEJB;

    @EJB
    InventarioEJB inventarioEJB;

    public InventarioMB() {
    }

    @PostConstruct
    public void init() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        zona = generalEJB.getZonas();
        fecha =  formatter.format(date);
    }

    public void ingresarProductoInventario() {

    }

    public void buscarProducto() {

    }

//    public void insertProduct() {
//
//        Productos productosVO = new Productos();
//
//        productosVO.setId(codigo);
//        System.out.println("codigo " + codigo);
//        productosVO.setNombre(nombreProducto);
//        System.out.println("nombre " + nombreProducto);
//        productosVO.setIva(IVA);
//        System.out.println("iva " + IVA);
//        productosVO.setPrecio(precio);
//        productosVO.setEmbalaje(embalaje);
//
//        System.out.println("valores " + productosVO.toString());
//        if (productosVO.getId() != null) {
//            generalEJB.create(productosVO);
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Producto Registrado");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        } else {
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo guardar Producto");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        }
//
//    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public CargueInventario getCargueInventario() {
        return cargueInventario;
    }

    public void setCargueInventario(CargueInventario cargueInventario) {
        this.cargueInventario = cargueInventario;
    }

    public List<Zona> getZona() {
        return zona;
    }

    public void setZona(List<Zona> zona) {
        this.zona = zona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public GeneralEJB getGeneralEJB() {
        return generalEJB;
    }

    public void setGeneralEJB(GeneralEJB generalEJB) {
        this.generalEJB = generalEJB;
    }

    public InventarioEJB getInventarioEJB() {
        return inventarioEJB;
    }

    public void setInventarioEJB(InventarioEJB inventarioEJB) {
        this.inventarioEJB = inventarioEJB;
    }
    
 
    
    

}
