/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findByCodigo", query = "SELECT m FROM Menu m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Menu.findByNombre", query = "SELECT m FROM Menu m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Menu.findByTipo", query = "SELECT m FROM Menu m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "Menu.findByTipoUsuario", query = "SELECT m FROM Menu m WHERE m.tipoUsuario = :tipoUsuario")
    , @NamedQuery(name = "Menu.findByEstado", query = "SELECT m FROM Menu m WHERE m.estado = :estado")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "url")
    private String url;
    
    @ManyToOne
    @JoinColumn(name = "codigo_submenu")
    private Menu subMenu;

    public Menu() {
    }

    public Menu(Integer codigo) {
        this.codigo = codigo;
    }

    public Menu(Integer codigo, String nombre, String tipo, String tipoUsuario, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Menu getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Menu subMenu) {
        this.subMenu = subMenu;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "codigo=" 
                + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", tipoUsuario=" + tipoUsuario + ", estado=" + estado + ", url=" + url + '}';
    }

   
    
}
