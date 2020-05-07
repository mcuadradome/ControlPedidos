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
@Table(name = "VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findById", query = "SELECT v FROM Venta v WHERE v.id = :id")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
    @JoinColumn(name = "cliente_fk", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente clienteFk;
    @JoinColumn(name = "vendedor_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vendedor vendedorFk;
    @JoinColumn(name = "id_zona_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Zona idZonaFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
    private List<OrdenVenta> ordenVentaList;

    public Venta() {
    }

    public Venta(Integer id) {
        this.id = id;
    }

    public Venta(Integer id, String fecha) {
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

    public Cliente getClienteFk() {
        return clienteFk;
    }

    public void setClienteFk(Cliente clienteFk) {
        this.clienteFk = clienteFk;
    }

    public Vendedor getVendedorFk() {
        return vendedorFk;
    }

    public void setVendedorFk(Vendedor vendedorFk) {
        this.vendedorFk = vendedorFk;
    }

    public Zona getIdZonaFk() {
        return idZonaFk;
    }

    public void setIdZonaFk(Zona idZonaFk) {
        this.idZonaFk = idZonaFk;
    }

    @XmlTransient
    public List<OrdenVenta> getOrdenVentaList() {
        return ordenVentaList;
    }

    public void setOrdenVentaList(List<OrdenVenta> ordenVentaList) {
        this.ordenVentaList = ordenVentaList;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniminuto.entidades.Venta[ id=" + id + " ]";
    }
    
}
