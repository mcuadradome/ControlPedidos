/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroventas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "ZONA")
@XmlRootElement
public class Zona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vendedor_fk")
    private int idVendedorFk;
    @Size(max = 10)
    @Column(name = "id_zona_fk")
    private String idZonaFk;
    @OneToMany(mappedBy = "idZonaFk")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZonaFk")
    private List<CargueInventario> cargueInventarioList;

    public Zona() {
    }

    public Zona(String id) {
        this.id = id;
    }

    public Zona(String id, String nombre, int idVendedorFk) {
        this.id = id;
        this.nombre = nombre;
        this.idVendedorFk = idVendedorFk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdVendedorFk() {
        return idVendedorFk;
    }

    public void setIdVendedorFk(int idVendedorFk) {
        this.idVendedorFk = idVendedorFk;
    }

    public String getIdZonaFk() {
        return idZonaFk;
    }

    public void setIdZonaFk(String idZonaFk) {
        this.idZonaFk = idZonaFk;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<CargueInventario> getCargueInventarioList() {
        return cargueInventarioList;
    }

    public void setCargueInventarioList(List<CargueInventario> cargueInventarioList) {
        this.cargueInventarioList = cargueInventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entidades.Zona[ id=" + id + " ]";
    }
    
}
