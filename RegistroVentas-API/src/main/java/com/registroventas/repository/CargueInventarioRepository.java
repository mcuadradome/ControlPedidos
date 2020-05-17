package com.registroventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registroventas.entidades.CargueInventario;
import com.registroventas.entidades.Usuario;
import com.registroventas.entidades.UsuarioRegistrado;

@Repository
public interface CargueInventarioRepository extends JpaRepository<CargueInventario, Integer>{
	
	
}
