/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.accesoBaseDatos.dto;

import com.example.accesoBaseDatos.dao.Usuarios;
import java.util.List;

/**
 *
 * @author JAR
 */
public class UsuariosWrapper {
    List<Usuarios> users;
    
    public UsuariosWrapper () {
        
    }

    public List<Usuarios> getUsers() {
        return users;
    }

    public void setUsers(List<Usuarios> users) {
        this.users = users;
    }
}