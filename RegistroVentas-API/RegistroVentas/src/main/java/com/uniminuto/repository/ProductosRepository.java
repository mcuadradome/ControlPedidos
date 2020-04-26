/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.repository;

import com.uniminuto.Entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel
 */
@Repository
public interface ProductosRepository extends JpaRepository<Productos, String>{
    
    
    
}
