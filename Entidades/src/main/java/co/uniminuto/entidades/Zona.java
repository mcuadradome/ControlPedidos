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
    , @NamedQuery(name = "Zona.findByIdVendedorFk", query = "SELECT z FROM Zona z WHERE z.idVendedorFk = :idVendedorFk")
    , @NamedQuery(name = "Zona.findByIdZonaFk", query = "SELECT z FROM Zona z WHERE z.idZonaFk = :idZonaFk")})
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
    @Column(name = "id_vendedor_fk")
    private int idVendedorFk;
    @Basic(optional = false)
    @Column(name = "id_zona_fk")
    private String idZonaFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZonaFk")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZonaFk")
    private List<CargueInventario> cargueInventarioList;

    public Zona() {
    }

    public Zona(String id) {
        this.id = id;
    }

    public Zona(String id, String nombre, int idVendedorFk, String idZonaFk) {
        this.id = id;
        this.nombre = nombre;
        this.idVendedorFk = idVendedorFk;
        this.idZonaFk = idZonaFk;
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
        return "co.uniminuto.entidades.Zona[ id=" + id + " ]";
    }
    
}
