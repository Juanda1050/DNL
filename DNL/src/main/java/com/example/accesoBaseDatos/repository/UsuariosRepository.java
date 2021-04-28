/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.accesoBaseDatos.repository;

import com.example.accesoBaseDatos.dao.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JAR
 */
@Repository
public interface UsuariosRepository extends JpaRepository <Usuarios, Integer> {  
    
}
