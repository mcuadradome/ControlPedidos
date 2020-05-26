/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registroventas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registroventas.entidades.Cliente;
import com.registroventas.entidades.Productos;
import com.registroventas.repository.ClienteRepository;
import com.registroventas.repository.ProductosRepository;
import com.registroventas.exception.*;


/**
 *
 * @author Miguel
 */

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class ClienteController {
    
    
    @Autowired
    private ClienteRepository clienteRepository;
    
     @GetMapping(value ="/clients")
    public List<Cliente> getClients(){
        return  clienteRepository.findAll();
    }
    
    @GetMapping(value ="/clients/{id}")
    public ResponseEntity<Cliente> getClientById(@PathVariable(value = "id") int clientId)
        throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(clientId)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + clientId));
        return ResponseEntity.ok().body(cliente);
    }
    
    @PostMapping(value ="/SaveClient")
    public Cliente createEmployee(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    @PutMapping(value ="/UpdateClient/{id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable int id,
         @Valid @RequestBody Cliente clienteDetails) throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
        	          
        cliente.setIdCliente(clienteDetails.getIdCliente());
        cliente.setIdentificacion(clienteDetails.getIdentificacion());
        cliente.setNombreCliente(clienteDetails.getNombreCliente());
        cliente.setTelefono(clienteDetails.getTelefono());
        cliente.setDireccion(clienteDetails.getDireccion());
       
        final Cliente updatedClient = clienteRepository.save(cliente);
        return ResponseEntity.ok(updatedClient);
    }
    
    @DeleteMapping(value ="/deleteClient/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable int id)
         throws ResourceNotFoundException {
        Cliente cliente = clienteRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));

        clienteRepository.delete(cliente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
