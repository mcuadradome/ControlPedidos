package com.registroventas.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registroventas.entidades.Productos;
import com.registroventas.entidades.Usuario;
import com.registroventas.entidades.UsuarioLogueado;
import com.registroventas.entidades.UsuarioRegistrado;
import com.registroventas.exception.ResourceNotFoundException;
import com.registroventas.repository.UsuarioRegistradoRepository;
import com.registroventas.repository.UsuarioRepository;
import com.registroventas.repository.UsuarioLogueadoRepository;;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioRegistradoRepository usuarioRegistradoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioLogueadoRepository usuarioLogueadoRepository;

	@GetMapping(value = "/usuario")
	public List<Usuario> getUsers() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping(value = "/usuarioRegistrado")
	public List<UsuarioRegistrado> getUseriosRegistrados() {
		return usuarioRegistradoRepository.findAll();
	}
	
	@GetMapping(value = "/usuarioLogueado")
	public List<UsuarioLogueado> getUserByUserAndPassword() {		
		return usuarioLogueadoRepository.findAll();// getByUserNameAndPassword(usuario, password);	
	}
	

	
	@PostMapping(value ="/saveUserLogueado")
    public UsuarioLogueado createUser(@Valid @RequestBody UsuarioLogueado usuarioLogueado) {
		UsuarioLogueado us = null;
		
		try {
        	usuarioLogueadoRepository.save(usuarioLogueado);         
            //us = usuarioLogueadoRepository.getUserLogueadoByIdusuario(usuarioLogueado.getIdUsuarioFk().getId());
        	us=usuarioLogueado;
		} catch (Exception e) {
			System.out.println("Error al ingresar usuarioLogueado " + e.getMessage());
		} 
		
		return us;
    }
	
	@DeleteMapping(value ="/userLogueado/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable int id)
         throws ResourceNotFoundException {
        UsuarioLogueado usuarioLogueado = usuarioLogueadoRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("User Logueado not found for this id :: " + id));

        usuarioLogueadoRepository.delete(usuarioLogueado);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}
