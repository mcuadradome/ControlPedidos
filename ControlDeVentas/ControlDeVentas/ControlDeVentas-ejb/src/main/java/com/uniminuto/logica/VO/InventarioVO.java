/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.logica.VO;

import co.uniminuto.entidades.CargueInventario;
import co.uniminuto.entidades.Productos;
import co.uniminuto.entidades.UsuarioRegistrado;
import co.uniminuto.entidades.Zona;

/**
 *
 * @author Miguel
 */
public class InventarioVO {
    
    private int usuarioRegistrado;
    private String zona;
    private String fecha;
    private int cantidad;
    private String producto;
    private int cargueInventario;
    private String nombre;

    public int getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    public void setUsuarioRegistrado(int usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCargueInventario() {
        return cargueInventario;
    }

    public void setCargueInventario(int cargueInventario) {
        this.cargueInventario = cargueInventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
