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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CARGUE_INVENTARIO")
public class CargueInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fecha")
    private String fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargueInventarioFk")
    private List<Inventario> inventarioList;
    @JoinColumn(name = "id_vendedor_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vendedor idVendedorFk;
    @JoinColumn(name = "id_zona_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Zona idZonaFk;

    public CargueInventario() {
    }

    public CargueInventario(Integer id) {
        this.id = id;
    }

    public CargueInventario(Integer id, String fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    public Vendedor getIdVendedorFk() {
        return idVendedorFk;
    }

    public void setIdVendedorFk(Vendedor idVendedorFk) {
        this.idVendedorFk = idVendedorFk;
    }

    public Zona getIdZonaFk() {
        return idZonaFk;
    }

    public void setIdZonaFk(Zona idZonaFk) {
        this.idZonaFk = idZonaFk;
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
        if (!(object instanceof CargueInventario)) {
            return false;
        }
        CargueInventario other = (CargueInventario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entidades.CargueInventario[ id=" + id + " ]";
    }
    
}
