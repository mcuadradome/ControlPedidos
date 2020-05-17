package com.registroventas.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO_REGISTRADO")
public class UsuarioRegistrado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_fk" , nullable = false)
	private UsuarioLogueado idUsuarioFK;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "estado")
	private String estado;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UsuarioLogueado getIdUsuarioFK() {
		return idUsuarioFK;
	}

	public void setIdUsuarioFK(UsuarioLogueado idUsuarioFK) {
		this.idUsuarioFK = idUsuarioFK;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	


}
