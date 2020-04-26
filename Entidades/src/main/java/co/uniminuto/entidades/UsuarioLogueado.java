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
@Table(name = "USUARIO_LOGUEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioLogueado.findAll", query = "SELECT u FROM UsuarioLogueado u")
    , @NamedQuery(name = "UsuarioLogueado.findById", query = "SELECT u FROM UsuarioLogueado u WHERE u.id = :id")
    , @NamedQuery(name = "UsuarioLogueado.findByRol", query = "SELECT u FROM UsuarioLogueado u WHERE u.rol = :rol")
    , @NamedQuery(name = "UsuarioLogueado.findByUsuario", query = "SELECT u FROM UsuarioLogueado u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "UsuarioLogueado.findByPassword", query = "SELECT u FROM UsuarioLogueado u WHERE u.password = :password")})
public class UsuarioLogueado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "rol")
    private String rol;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuarioFk;

    public UsuarioLogueado() {
    }

    public UsuarioLogueado(Integer id) {
        this.id = id;
    }

    public UsuarioLogueado(Integer id, String rol, String usuario, String password) {
        this.id = id;
        this.rol = rol;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
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
        if (!(object instanceof UsuarioLogueado)) {
            return false;
        }
        UsuarioLogueado other = (UsuarioLogueado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniminuto.entidades.UsuarioLogueado[ id=" + id + " ]";
    }
    
}