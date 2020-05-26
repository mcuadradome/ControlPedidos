package com.registroventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registroventas.entidades.Usuario;
import com.registroventas.entidades.UsuarioLogueado;
import com.registroventas.entidades.UsuarioRegistrado;

@Repository
public interface UsuarioLogueadoRepository extends JpaRepository<UsuarioLogueado, Integer>{
//	
//	UsuarioLogueado getUserLogueadoByUser(String user);
//	UsuarioLogueado getUserLogueadoByIdusuario(int idUsuario);
}
