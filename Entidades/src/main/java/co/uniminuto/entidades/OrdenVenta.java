/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "ORDEN_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenVenta.findAll", query = "SELECT o FROM OrdenVenta o")
    , @NamedQuery(name = "OrdenVenta.findByIdOrden", query = "SELECT o FROM OrdenVenta o WHERE o.idOrden = :idOrden")
    , @NamedQuery(name = "OrdenVenta.findByCantidad", query = "SELECT o FROM OrdenVenta o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenVenta.findByTotalProducto", query = "SELECT o FROM OrdenVenta o WHERE o.totalProducto = :totalProducto")
    , @NamedQuery(name = "OrdenVenta.findByPrecioProducto", query = "SELECT o FROM OrdenVenta o WHERE o.precioProducto = :precioProducto")
    , @NamedQuery(name = "OrdenVenta.findByPorPaquete", query = "SELECT o FROM OrdenVenta o WHERE o.porPaquete = :porPaquete")})
public class OrdenVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_orden")
    private Integer idOrden;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "total_producto")
    private int totalProducto;
    @Basic(optional = false)
    @Column(name = "precio_producto")
    private int precioProducto;
    @Basic(optional = false)
    @Column(name = "por_paquete")
    private boolean porPaquete;
    @JoinColumn(name = "id_producto_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Productos idProductoFk;
    @JoinColumn(name = "id_venta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Venta idVenta;

    public OrdenVenta() {
    }

    public OrdenVenta(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public OrdenVenta(Integer idOrden, int cantidad, int totalProducto, int precioProducto, boolean porPaquete) {
        this.idOrden = idOrden;
        this.cantidad = cantidad;
        this.totalProducto = totalProducto;
        this.precioProducto = precioProducto;
        this.porPaquete = porPaquete;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(int totalProducto) {
        this.totalProducto = totalProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public boolean getPorPaquete() {
        return porPaquete;
    }

    public void setPorPaquete(boolean porPaquete) {
        this.porPaquete = porPaquete;
    }

    public Productos getIdProductoFk() {
        return idProductoFk;
    }

    public void setIdProductoFk(Productos idProductoFk) {
        this.idProductoFk = idProductoFk;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenVenta)) {
            return false;
        }
        OrdenVenta other = (OrdenVenta) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniminuto.entidades.OrdenVenta[ idOrden=" + idOrden + " ]";
    }
    
}
