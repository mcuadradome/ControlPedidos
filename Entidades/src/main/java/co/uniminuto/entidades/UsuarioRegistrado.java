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
@Table(name = "USUARIO_REGISTRADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRegistrado.findAll", query = "SELECT u FROM UsuarioRegistrado u")
    , @NamedQuery(name = "UsuarioRegistrado.findById", query = "SELECT u FROM UsuarioRegistrado u WHERE u.id = :id")
    , @NamedQuery(name = "UsuarioRegistrado.findByUsuario", query = "SELECT u FROM UsuarioRegistrado u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "UsuarioRegistrado.findByPassword", query = "SELECT u FROM UsuarioRegistrado u WHERE u.password = :password")})
public class UsuarioRegistrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuarioFk;

    public UsuarioRegistrado() {
    }

    public UsuarioRegistrado(Integer id) {
        this.id = id;
    }

    public UsuarioRegistrado(Integer id, String usuario, String password) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof UsuarioRegistrado)) {
            return false;
        }
        UsuarioRegistrado other = (UsuarioRegistrado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.uniminuto.entidades.UsuarioRegistrado[ id=" + id + " ]";
    }
    
}
