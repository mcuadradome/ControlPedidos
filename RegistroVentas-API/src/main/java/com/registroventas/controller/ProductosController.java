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

import com.registroventas.entidades.Productos;
import com.registroventas.repository.ProductosRepository;
import com.registroventas.exception.*;


/**
 *
 * @author Miguel
 */

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class ProductosController {
    
    
    @Autowired
    private ProductosRepository productosRepository;
    
     @GetMapping(value ="/products")
    public List<Productos> getProducts(){
        return  productosRepository.findAll();
    }
    
    @GetMapping(value ="/products/{id}")
    public ResponseEntity<Productos> getProductsById(@PathVariable(value = "id") String productId)
        throws ResourceNotFoundException {
        Productos productos = productosRepository.findById(productId)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(productos);
    }
    
    @PostMapping(value ="/Saveproduct")
    public Productos createEmployee(@Valid @RequestBody Productos employee) {
        return productosRepository.save(employee);
    }
    
    @PutMapping(value ="/Updateproduct/{id}")
    public ResponseEntity<Productos> updateProduct(@PathVariable String id,
         @Valid @RequestBody Productos productDetails) throws ResourceNotFoundException {
        Productos product = productosRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        
        product.setId(productDetails.getId());
        product.setNombre(productDetails.getNombre());
        product.setIva(productDetails.getIva());
        product.setPrecio(productDetails.getPrecio());
        product.setEmbalaje(productDetails.getEmbalaje());
        
       
        final Productos updatedProduct = productosRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }
    
    @DeleteMapping(value ="/deleteProduct/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable String id)
         throws ResourceNotFoundException {
        Productos product = productosRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

        productosRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
