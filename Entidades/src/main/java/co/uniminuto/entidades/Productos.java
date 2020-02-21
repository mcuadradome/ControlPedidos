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

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "PRODUCTOS")
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Productos.findByPrecioBase", query = "SELECT p FROM Productos p WHERE p.precioBase = :precioBase"),
    @NamedQuery(name = "Productos.findByEmbalaje", query = "SELECT p FROM Productos p WHERE p.embalaje = :embalaje"),
    @NamedQuery(name = "Productos.findByIva", query = "SELECT p FROM Productos p WHERE p.iva = :iva")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_producto")
    private String idProducto;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "precio_base")
    private int precioBase;
    @Basic(optional = false)
    @Column(name = "embalaje")
    private int embalaje;
    @Basic(optional = false)
    @Column(name = "iva")
    private int iva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProductoFk")
    private List<Orden> ordenList;

    public Productos() {
    }

    public Productos(String idProducto) {
        this.idProducto = idProducto;
    }

    public Productos(String idProducto, String descripcion, int precioBase, int embalaje, int iva) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.embalaje = embalaje;
        this.iva = iva;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public int getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(int embalaje) {
        this.embalaje = embalaje;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniminuto.entidades.Productos[ idProducto=" + idProducto + " ]";
    }
    
}
