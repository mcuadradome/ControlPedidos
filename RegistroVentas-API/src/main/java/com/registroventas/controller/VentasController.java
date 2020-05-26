package com.registroventas.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;
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

import com.registroventas.entidades.CargueInventario;
import com.registroventas.entidades.Inventario;
import com.registroventas.entidades.OrdenVenta;
import com.registroventas.entidades.Productos;
import com.registroventas.entidades.Usuario;
import com.registroventas.entidades.UsuarioLogueado;
import com.registroventas.entidades.UsuarioRegistrado;
import com.registroventas.entidades.Venta;
import com.registroventas.exception.ResourceNotFoundException;
import com.registroventas.repository.UsuarioRegistradoRepository;
import com.registroventas.repository.UsuarioRepository;
import com.registroventas.repository.VentaRepository;
import com.registroventas.repository.CargueInventarioRepository;
import com.registroventas.repository.InventarioRepository;
import com.registroventas.repository.OrdenVentaRepository;
import com.registroventas.repository.UsuarioLogueadoRepository;;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class VentasController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private InventarioRepository inventarioRepository;

	@Autowired
	private CargueInventarioRepository cargueInventarioRepository;

	@Autowired
	private VentaRepository ventaRepository;
	
	@Autowired
	private OrdenVentaRepository ordenVentaRepository;

	@GetMapping(value = "/getInventario")
	public List<Inventario> getInventario() {
		return inventarioRepository.findAll();
	}
	
	@GetMapping(value = "/getCargueInventario")
	public List<CargueInventario> getCargueInventario() {		
		return cargueInventarioRepository.findAll();
	}
	
	
	@PostMapping(value ="/saveInventario")
    public Inventario createInventario(@Valid @RequestBody Inventario inventario) {
		Inventario us = null;
		
		try {
        	inventarioRepository.save(inventario);         
            //us = usuarioLogueadoRepository.getUserLogueadoByIdusuario(usuarioLogueado.getIdUsuarioFk().getId());
        	us=inventario;
		} catch (Exception e) {
			System.out.println("Error al ingresar usuarioLogueado " + e.getMessage());
		} 
		
		return us;
    }
	
	@PostMapping(value ="/saveVenta")
    public Venta createVenta(@Valid @RequestBody Venta venta) {
		
		
		try {
        	return ventaRepository.save(venta);         
            //us = usuarioLogueadoRepository.getUserLogueadoByIdusuario(usuarioLogueado.getIdUsuarioFk().getId());
        	
		} catch (Exception e) {
			System.out.println("Error al ingresar usuarioLogueado " + e.getMessage());
		} 
		
		return null;
    }
	
	@PostMapping(value ="/saveOrdenVenta")
    public OrdenVenta createVenta(@Valid @RequestBody OrdenVenta venta) {
		OrdenVenta us = null;
		
		try {
        	ordenVentaRepository.save(venta);         
            //us = usuarioLogueadoRepository.getUserLogueadoByIdusuario(usuarioLogueado.getIdUsuarioFk().getId());
        	us=venta;
		} catch (Exception e) {
			System.out.println("Error al ingresar usuarioLogueado " + e.getMessage());
		} 
		
		return us;
    }
	
	@PostMapping(value ="/saveCargueInventario")
    public CargueInventario createCargueInventario(@Valid @RequestBody CargueInventario inventario) {
		CargueInventario us = null;
		
		try {
        	cargueInventarioRepository.save(inventario);         
            //us = usuarioLogueadoRepository.getUserLogueadoByIdusuario(usuarioLogueado.getIdUsuarioFk().getId());
        	us=inventario;
		} catch (Exception e) {
			System.out.println("Error al ingresar usuarioLogueado " + e.getMessage());
		} 
		
		return us;
    }
	
	@DeleteMapping(value ="/Inventario/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable int id)
         throws ResourceNotFoundException {
        Inventario usuarioLogueado = inventarioRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("User Logueado not found for this id :: " + id));

        inventarioRepository.delete(usuarioLogueado);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}
