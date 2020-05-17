/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroventas.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "USUARIO_LOGUEADO")
@XmlRootElement
public class UsuarioLogueado implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
   
    @JoinColumn(name = "id_usuario_fk", nullable = false)
    @ManyToOne
    private Usuario idUsuarioFk;
    
    @Column
    private String usuario;

    public UsuarioLogueado() {
    }

    public UsuarioLogueado(Integer id) {
        this.id = id;
    }

    public UsuarioLogueado(Integer id, Usuario idUsuarioFK, String usuario ) {
        this.id = id;
        this.idUsuarioFk = idUsuarioFK;
        this.usuario = usuario;
    }

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getIdUsuarioFk() {
		return idUsuarioFk;
	}

	public void setIdUsuarioFk(Usuario idUsuarioFk) {
		this.idUsuarioFk = idUsuarioFk;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

   
    
}
