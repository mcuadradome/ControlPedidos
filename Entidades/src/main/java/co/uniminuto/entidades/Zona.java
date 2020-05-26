/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.entidades;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "ZONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z")
    , @NamedQuery(name = "Zona.findById", query = "SELECT z FROM Zona z WHERE z.id = :id")
    , @NamedQuery(name = "Zona.findByNombre", query = "SELECT z FROM Zona z WHERE z.nombre = :nombre")
    , @NamedQuery(name = "Zona.findByIdVendedorFk", query = "SELECT z FROM Zona z WHERE z.idVendedorFk = :idVendedorFk")})
public class Zona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    
    @ManyToOne
    @JoinColumn(name = "id_vendedor_fk")
    private UsuarioRegistrado idVendedorFk;
  
    public Zona() {
    }

    public Zona(String id) {
        this.id = id;
    }

    public Zona(String id, String nombre, UsuarioRegistrado idVendedorFk, Vendedor idZonaFk) {
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

    public UsuarioRegistrado getIdVendedorFk() {
        return idVendedorFk;
    }

    public void setIdVendedorFk(UsuarioRegistrado idVendedorFk) {
        this.idVendedorFk = idVendedorFk;
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
        return "co.uniminuto.entidades.Zona[ id=" + id + " ]";
    }
    
}
