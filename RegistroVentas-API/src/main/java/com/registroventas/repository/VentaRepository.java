package com.registroventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registroventas.entidades.Usuario;
import com.registroventas.entidades.UsuarioRegistrado;
import com.registroventas.entidades.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{
	
	
}
