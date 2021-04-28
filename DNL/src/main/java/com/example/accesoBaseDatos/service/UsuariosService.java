/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.accesoBaseDatos.service;

import com.example.accesoBaseDatos.dao.Usuarios;
import java.util.List;

/**
 *
 * @author JAR
 */
public interface UsuariosService {
    public List<Usuarios> getAll();
    public Usuarios create (Usuarios dto);// <--- NUEVO
    public void eliminar (Integer idUsuario);// <--- NUEVO

    public Usuarios update(Usuarios userForm);
}